package ru.geekbrains.controller.data;

import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.model.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductData {

    private Long id;
    @NotEmpty
    @Size(min=3, max=20, message="Title must have 3-20 characters")
    private String title;
    @NotEmpty
    @Size(min=3, max=20, message="Title must have 3-20 characters")
    private String brandName;

    private String image;

    private BigDecimal price;

    private Category category;

    public ProductData() {
    }

    public ProductData(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.brandName = product.getBrandName();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.category = product.getCategory();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    @Override
//    public String toString() {
//        return "ProductData{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", brandName='" + brandName + '\'' +
//                ", price=" + price +
//                '}';
//    }


    @Override
    public String toString() {
        return "ProductData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brandName='" + brandName + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", categtory=" + category.getName() +
                '}';
    }
}
