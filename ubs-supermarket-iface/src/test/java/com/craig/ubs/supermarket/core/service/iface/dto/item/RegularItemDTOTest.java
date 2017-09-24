package com.craig.ubs.supermarket.core.service.iface.dto.item;

import com.craig.ubs.supermarket.core.service.iface.Item;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO.Builder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularItemDTOTest {

    @Test
    public void checkRegularItemSingleItemCost() {
        String sku = "sku";
        String item = "item";
        double price = .50;

        Item regularItemDTO = new RegularItemDTO.Builder()
                .withSku(sku)
                .withItem(item)
                .withPrice(price)
                .build();

        double dtoPrice = regularItemDTO.getPrice();

        assertEquals(price, dtoPrice, 0);
    }

    @Test
    public void checkTotalPrice() {
        Item calculateTotal = new Builder().withItem("item").withSku("sku").withPrice(.50).build();

        double cost = calculateTotal.getTotalForItemFunction().apply(5);

        assertEquals(5 * .50, cost, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThowExceptionOnNegativePrice(){
        Item calculateTotal = new Builder().withItem("item").withSku("sku").withPrice(-1).build();
    }


}