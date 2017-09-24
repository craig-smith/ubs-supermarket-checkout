package com.craig.ubs.supermarket.core.data;

public class EntityCreator {

    public static RegularItemEntity getRegularEntityForTest(String item, String sku, double price) {
        RegularItemEntity regularItemEntity = new RegularItemEntity();
        regularItemEntity.setItem(item);
        regularItemEntity.setPrice(price);
        regularItemEntity.setSku(sku);
        return regularItemEntity;
    }

    public static SpecialItemEntity getSpecialItemEntityForTest(String item, String sku, double price, int buyAmount, double discountPrice) {
        SpecialItemEntity specialItemEntity = new SpecialItemEntity();
        specialItemEntity.setBuyAmount(buyAmount);
        specialItemEntity.setDiscountPrice(discountPrice);
        specialItemEntity.setItem(item);
        specialItemEntity.setPrice(price);
        specialItemEntity.setSku(sku);

        return specialItemEntity;
    }

}
