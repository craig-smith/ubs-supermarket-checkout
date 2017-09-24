package com.craig.ubs.supermarket.core.service.iface.dto.item;

import com.craig.ubs.supermarket.core.service.iface.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpecialItemDTOTest {

    @Test
    public void checkDiscountValueIsCorrect() {

        Item item = new SpecialItemDTO.Builder()
                .withItem("item")
                .withPrice(.50)
                .withSku("sku")
                .withBuyAmount(3)
                .withDiscountPrice(1)
                .build();

        assertEquals(.50, item.getPrice(), 0);

        assertEquals(1, item.getTotalForItemFunction().apply(3), 0);

        Item item2 = new SpecialItemDTO.Builder()
                .withItem("item")
                .withPrice(.60)
                .withSku("sku")
                .withBuyAmount(4)
                .withDiscountPrice(1)
                .build();

        assertEquals(.60, item2.getPrice(), 0);
        assertEquals(1, item2.getTotalForItemFunction().apply(4), 0);
    }

    @Test
    public void checkDiscountValueIsCorrectPlusOne() {
        Item item = new SpecialItemDTO.Builder()
                .withItem("item")
                .withPrice(.50)
                .withSku("sku")
                .withBuyAmount(3)
                .withDiscountPrice(1)
                .build();

        assertEquals(.50, item.getPrice(), 0);
        assertEquals(1.50, item.getTotalForItemFunction().apply(4), 0);
    }

    @Test
    public void checkDiscountValueIsCorrectPluseTwo() {
        Item item = new SpecialItemDTO.Builder()
                .withItem("item")
                .withPrice(1.50)
                .withSku("sku")
                .withBuyAmount(3)
                .withDiscountPrice(3)
                .build();

        assertEquals(1.50, item.getPrice(), 0);
        assertEquals(6, item.getTotalForItemFunction().apply(5), 0);

    }

}