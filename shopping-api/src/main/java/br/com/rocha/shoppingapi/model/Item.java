package br.com.rocha.shoppingapi.model;

import br.com.rocha.shoppingapi.dto.ItemDTO;
import jakarta.persistence.Embeddable;

@Embeddable
public class Item {

    private String productIdentifier;
    private Float price;

    public String getProductIdentifier() {
        return productIdentifier;
    }
    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    public static Item convert(ItemDTO ItemDTO){

        Item item = new Item();
        item.setProductIdentifier(ItemDTO.getProductIdentifier());
        item.setPrice(ItemDTO.getPrice());

        return item;
    }
    
    
}
