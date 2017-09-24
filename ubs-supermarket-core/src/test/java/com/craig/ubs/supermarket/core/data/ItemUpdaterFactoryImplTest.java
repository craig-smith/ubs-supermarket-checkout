package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import com.craig.ubs.supermarket.core.transformer.ItemEntityUpdaterFactory;
import com.craig.ubs.supermarket.core.transformer.ItemUpdater;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ItemUpdaterFactoryImplTest {

    private ItemEntityUpdaterFactory itemEntityUpdaterFactory = new ItemUpdaterFactoryImpl();

    @Test
    public void getUpdater() throws Exception {
        SpecialItemEntity specialItemEntity = new SpecialItemEntity();
        specialItemEntity.setSku("123");
        specialItemEntity.setPrice(1.00);
        specialItemEntity.setItem("item");
        specialItemEntity.setDiscountPrice(3.00);
        specialItemEntity.setBuyAmount(4);

        SpecialItemDTO specialItemDTO = new SpecialItemDTO.Builder()
                .withItem("newItem")
                .withPrice(2.00)
                .withSku("1234")
                .withBuyAmount(5)
                .withBuyAmount(4)
                .build();

        ItemUpdater itemUpdater = itemEntityUpdaterFactory.getUpdater(specialItemEntity, specialItemDTO);
        assertNotNull(itemUpdater);
        assertTrue(itemUpdater instanceof SpecialItemEntityUpdater);

        RegularItemEntity regularItemEntity = new RegularItemEntity();
        regularItemEntity.setSku("SKU");
        regularItemEntity.setPrice(1.00);
        regularItemEntity.setItem("someName");

        RegularItemDTO regularItemDTO = new RegularItemDTO.Builder()
                .withItem("item")
                .withPrice(2.00)
                .withSku("001")
                .build();

        ItemUpdater itemUpdater2 = itemEntityUpdaterFactory.getUpdater(regularItemEntity, regularItemDTO);
        assertNotNull(itemUpdater2);
        assertTrue(itemUpdater2 instanceof RegularItemEntityUpdater);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoTransformerForIncompatibleTypes() {
        SpecialItemEntity specialItemEntity = new SpecialItemEntity();
        specialItemEntity.setSku("123");
        specialItemEntity.setPrice(1.00);
        specialItemEntity.setItem("item");
        specialItemEntity.setDiscountPrice(3.00);
        specialItemEntity.setBuyAmount(4);

        RegularItemDTO regularItemDTO = new RegularItemDTO.Builder()
                .withItem("item")
                .withPrice(2.00)
                .withSku("001")
                .build();

        itemEntityUpdaterFactory.getUpdater(specialItemEntity, regularItemDTO);
    }

}