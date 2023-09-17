package br.com.rocha.shoppingclient.dto;


import javax.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull
    private Long id;
    private String name;

    public CategoryDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}