package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpecialItemEntityTransformerTest {

    private SpecialItemEntityTransformer specialItemEntityTransformer = new SpecialItemEntityTransformer();

    @Test
    public void transform() throws Exception {

        SpecialItemEntity specialItemEntity = new SpecialItemEntity();
        specialItemEntity.setSku("123");
        specialItemEntity.setPrice(1.00);
        specialItemEntity.setItem("item");
        specialItemEntity.setDiscountPrice(3.00);
        specialItemEntity.setBuyAmount(4);

        SpecialItemDTO item = specialItemEntityTransformer.transform(specialItemEntity);
        assertEquals(specialItemEntity.getItem(), item.getItem());
        assertEquals(specialItemEntity.getPrice(), item.getPrice(), 0);
        assertEquals(specialItemEntity.getSku(), item.getSku());
        assertEquals(specialItemEntity.getBuyAmount(), item.getBuyAmount());
        assertEquals(specialItemEntity.getDiscountPrice(), item.getDiscountPrice(), 0);

    }

}