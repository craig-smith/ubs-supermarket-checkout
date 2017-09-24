package com.craig.ubs.supermarket.core.service.iface.dto.item;

import org.apache.commons.lang.Validate;

import java.util.function.Function;

/**
 * Representation of SpecialItemEntity to be used outside of ubs-supermarket-core lib
 */
public class SpecialItemDTO extends ItemDTOAbstract {

    private int buyAmount;

    private double discountPrice;

    public SpecialItemDTO(Builder builder) {
        super(builder.getSku(), builder.getItem(), builder.getPrice());
        Validate.isTrue(builder.getBuyAmount() > -1, "Buy amount must be 0 or greater");
        Validate.isTrue(builder.getDiscountPrice() < builder.getPrice() * builder.getBuyAmount(), "Discount should be smaller than regular price");
        this.buyAmount = builder.getBuyAmount();
        this.discountPrice = builder.getDiscountPrice();
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public Function<Integer, Double> getTotalForItemFunction() {
        return integer -> ((integer % buyAmount) * price) + ((integer / buyAmount) * discountPrice);
    }

    public static class Builder {

        private String sku;
        private String item;
        private double price;
        private int buyAmount;
        private double discountPrice;

        public Builder withItem(String item) {
            this.item = item;
            return this;
        }

        public Builder withSku(String sku) {
            this.sku = sku;
            return this;
        }

        public Builder withPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder withBuyAmount(int buyAmount) {
            this.buyAmount = buyAmount;
            return this;
        }

        public Builder withDiscountPrice(double discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }

        public int getBuyAmount() {
            return buyAmount;
        }

        public double getDiscountPrice() {
            return discountPrice;
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

        public SpecialItemDTO build() {
            return new SpecialItemDTO(this);
        }
    }
}
