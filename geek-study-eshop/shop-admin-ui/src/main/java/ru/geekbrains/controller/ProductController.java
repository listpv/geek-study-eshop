package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.controller.data.CategoryData;
import ru.geekbrains.controller.data.ProductData;
import ru.geekbrains.error.NotFoundException;
import ru.geekbrains.service.CategoryService;
import ru.geekbrains.service.ProductService;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String adminProductsPage(Model model) {
        model.addAttribute("activePage", "Products");
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/categories")
    public String adminCategoriesPage(Model model) {
        model.addAttribute("activePage", "Categories");
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @GetMapping("/product/create")
    public String adminCreateProduct(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", new ProductData());
        model.addAttribute("categories",categoryService.findAll());
        return "product_form";
    }

    @GetMapping("/category/create")
    public String adminCreateCategory(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Categories");
        model.addAttribute("category", new CategoryData());
//        model.addAttribute("categories",categoryService.findAll());
        return "category_form";
    }

    @PostMapping("/product")
    public String adminUpsertUser(@Valid ProductData product, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Products");

        if (bindingResult.hasErrors()) {
            return "product_form";
        }

        System.out.println(product);
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/category")
    public String adminUpsertCategory(@Valid CategoryData category, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Categories");

        if (bindingResult.hasErrors()) {
            return "category_form";
        }

        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/category/{id}/demonstrate")
    public String adminDemontrateCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("activePage", "Categories");
        model.addAttribute("categories", categoryService.findById(id).orElseThrow(NotFoundException::new));
        return "category_demonstrate";
    }

    @DeleteMapping("/product/{id}/delete")
    public String adminDeleteProduct(Model model, @PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
