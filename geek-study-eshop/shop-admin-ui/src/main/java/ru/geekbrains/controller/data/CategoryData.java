package ru.geekbrains.controller.data;

import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.model.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class CategoryData {

    private Long id;

    @NotEmpty
    @Size(min=3, max=20, message="Title must have 3-20 characters")
    private String code;

    @NotEmpty
    @Size(min=3, max=20, message="Title must have 3-20 characters")
    private String name;

    private List<Product> productList;

    public CategoryData() {
    }

    public CategoryData(Category category) {
        this.id = category.getId();
        this.code = category.getCode();
        this.name = category.getName();
        this.productList = category.getProductList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "CategoryData{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }


//    @Override
//    public String toString() {
//        return name;
//    }
}
