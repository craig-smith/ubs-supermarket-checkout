package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.transformer.ItemEntityTransformer;
import com.craig.ubs.supermarket.core.transformer.ItemEntityTransformerFactory;
import com.craig.ubs.supermarket.core.transformer.RegularItemEntityTransformer;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ItemEntityTransformerFactoryImplTest {

    private ItemEntityTransformerFactory itemEntityTransformerFactory = new ItemEntityTransformerFactoryImpl();

    @Test
    public void getTransformer() throws Exception {

        RegularItemEntity regularItemEntity = new RegularItemEntity();
        regularItemEntity.setSku("SKU");
        regularItemEntity.setPrice(1.00);
        regularItemEntity.setItem("someName");

        ItemEntityTransformer transformer = itemEntityTransformerFactory.getTransformer(regularItemEntity);
        assertNotNull(transformer);
        assertTrue(transformer instanceof RegularItemEntityTransformer);

        SpecialItemEntity specialItemEntity = new SpecialItemEntity();
        specialItemEntity.setSku("123");
        specialItemEntity.setPrice(1.00);
        specialItemEntity.setItem("item");
        specialItemEntity.setDiscountPrice(3.00);
        specialItemEntity.setBuyAmount(4);

        ItemEntityTransformer transformer2 = itemEntityTransformerFactory.getTransformer(specialItemEntity);
        assertNotNull(transformer2);
        assertTrue(transformer2 instanceof SpecialItemEntityTransformer);
    }

}