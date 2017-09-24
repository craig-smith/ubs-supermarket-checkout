package com.craig.ubs.supermarket.core.service.iface.dto.item;

import java.util.function.Function;

/**
 * Representation of RegularItemEntity to be used outside of ubs-supermarket-core lib
 */
public class RegularItemDTO extends ItemDTOAbstract {

    private RegularItemDTO(Builder builder) {
        super(builder.getSku(), builder.getItem(), builder.getPrice());
    }

    @Override
    public Function<Integer, Double> getTotalForItemFunction() {
        return integer -> integer * price;
    }

    public static class Builder {

        private String sku;
        private String item;
        private double price;

        public Builder withItem(String item) {
            this.item = item;
            return this;
        }

        public Builder withSku(String sku){
            this.sku = sku;
            return this;
        }

        public Builder withPrice(double price){
            this.price = price;
            return this;
        }

        public RegularItemDTO build() {
            return new RegularItemDTO(this);
        }

        public String getSku() {
            return sku;
        }

        public String getItem() {
            return item;
        }

        public double getPrice() {
            return price;
        }
    }

}
