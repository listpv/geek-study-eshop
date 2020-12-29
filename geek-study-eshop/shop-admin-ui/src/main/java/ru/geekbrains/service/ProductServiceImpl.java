package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.controller.data.ProductData;
import ru.geekbrains.persist.model.Product;
import ru.geekbrains.persist.repo.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductData productData) {

        Product product = new Product();
        product.setId(productData.getId());
        product.setTitle(productData.getTitle());
        product.setBrandName(productData.getBrandName());
        product.setPrice(productData.getPrice());
        product.setCategory(productData.getCategory());
        productRepository.save(product);

    }

    @Override
    public List<ProductData> findAll() {
        return productRepository.findAll().stream()
                .map(ProductData::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductData> findById(Long id) {
        return productRepository.findById(id).map(ProductData::new);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
