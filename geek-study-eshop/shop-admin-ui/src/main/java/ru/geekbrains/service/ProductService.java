package ru.geekbrains.service;

import ru.geekbrains.controller.data.ProductData;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void save(ProductData productData);

    List<ProductData> findAll();

    Optional<ProductData> findById(Long id);

    void delete(Long id);
}
