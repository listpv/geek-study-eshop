package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.controller.data.CategoryData;
import ru.geekbrains.controller.data.RoleData;
import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.repo.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(CategoryData categoryData) {
        Category category = new Category();
        category.setId(categoryData.getId());
        category.setCode(categoryData.getCode());
        category.setName(categoryData.getName());
        category.setProductList(categoryData.getProductList());
        categoryRepository.save(category);
    }

    @Override
    public Optional<CategoryData> findById(Long id) {
        return categoryRepository.findById(id).map(CategoryData::new);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}
