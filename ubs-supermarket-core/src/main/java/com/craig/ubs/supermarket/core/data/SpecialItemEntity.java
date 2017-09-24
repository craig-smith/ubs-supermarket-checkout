package com.craig.ubs.supermarket.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "SPECIAL_ITEM")
class SpecialItemEntity extends ItemEntity {

    @Column(name = "BUY_AMOUNT", nullable = false)
    private int buyAmount;

    @Column(name = "DISCOUNT_PRICE", nullable = false)
    private double discountPrice;

    public SpecialItemEntity() {
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}
