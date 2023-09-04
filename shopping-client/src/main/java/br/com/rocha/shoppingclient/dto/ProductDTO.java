package br.com.rocha.shoppingclient.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Float price;
    @NotNull
    private CategoryDTO category;

    public ProductDTO() {
    }

    public String getProductIdentifier() {
        return this.productIdentifier;
    }

    public void setProductIdentifier(final String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.nome = name;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(final Float price) {
        this.preco = price;
    }

    public CategoryDTO getCategory() {
        return this.category;
    }

    public void setCategory(final CategoryDTO category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}