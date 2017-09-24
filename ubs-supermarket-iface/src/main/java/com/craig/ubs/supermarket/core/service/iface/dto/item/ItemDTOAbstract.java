package com.craig.ubs.supermarket.core.service.iface.dto.item;

import com.craig.ubs.supermarket.core.service.iface.Item;
import org.apache.commons.lang.Validate;

/**
 * abstract representation of ItemEntity used outside of ubs-supermarket-core lib to transfer data about Entities
 */
public abstract class ItemDTOAbstract implements Item {

    private String sku;

    private String item;

    protected double price;


    public ItemDTOAbstract(String sku, String item, Double price) {
        Validate.notNull(sku, "sku cannot be null!");
        Validate.notNull(item, "item cannot be null!");
        Validate.isTrue(price > 0, "price must be greater than zero, Nothing's free!!");
        this.sku = sku;
        this.item = item;
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String getSku() {
        return this.sku;
    }

    @Override
    public String getItem() {
        return this.item;
    }

}
