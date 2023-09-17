package br.com.rocha.productapi.converter;


import br.com.rocha.productapi.model.Category;
import br.com.rocha.productapi.model.Product;
import br.com.rocha.shoppingclient.dto.CategoryDTO;
import br.com.rocha.shoppingclient.dto.ProductDTO;

public class DTOConverter {

    public static CategoryDTO convert(final Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    public static ProductDTO convert(final Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        if (product.getCategory() != null) {
            productDTO.setCategory(DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }

}