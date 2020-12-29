package ru.geekbrains.service;

import ru.geekbrains.controller.data.CategoryData;
import ru.geekbrains.controller.data.RoleData;
import ru.geekbrains.persist.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public void save(CategoryData categoryData);

    Optional<CategoryData> findById(Long id);

    public List<Category> findAll();
}
