package br.com.rocha.shoppingapi.model;

import br.com.rocha.shoppingclient.dto.ItemDTO;
import jakarta.persistence.Embeddable;

@Embeddable
public class Item {

    private String productIdentifier;
    private Float price;

    public Item() {
    }

    public String getProductIdentifier() {
        return this.productIdentifier;
    }

    public void setProductIdentifier(final String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(final Float price) {
        this.price = price;
    }

    public static Item convert(final ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }

}