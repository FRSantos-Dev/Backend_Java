package br.com.rocha.productapi.dto;

import br.com.rocha.productapi.model.Category;
import jakarta.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CategoryDTO convert(Category category) {

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

}
