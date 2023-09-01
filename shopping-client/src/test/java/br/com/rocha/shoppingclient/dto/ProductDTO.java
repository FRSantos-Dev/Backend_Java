package br.com.rocha.shoppingclient.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String name;
    @NotBlank
    private String desciption;
    @NotNull
    private Float price;
    @NotNull
    private CategoryDTO category;

    public ProductDTO() {
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

}