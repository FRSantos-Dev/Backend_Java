package br.com.rocha.productapi.converter;

import br.com.rocha.productapi.model.Category;
import br.com.rocha.productapi.model.Product;

public class DTOConverter {

    public static CategoryDTO convert (Category categpory){

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categpory.getId());
        categoryDTO.setName(categpory.getName());

        return categoryDTO;
    }

    public static ProductDTO convert(Product product){
            
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            
            if(product.getCategory() != null){
                productDTO.setCategory(DTOConverter.convert(product.getCategory()));
            }
            return productDTO;
    }

    public static ProductDTO convert(Product product){

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());

        if(product.getCategory() != null){
            productDTO.setCategory(DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }
}
