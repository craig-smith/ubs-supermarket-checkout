package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.transformer.RegularItemEntityTransformer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RegularItemEntityTransformerTest {

    private RegularItemEntityTransformer regularItemEntityTransformer = new RegularItemEntityTransformer();

    @Test
    public void transform() throws Exception {
        RegularItemEntity regularItemEntity = new RegularItemEntity();
        regularItemEntity.setSku("SKU");
        regularItemEntity.setPrice(1.00);
        regularItemEntity.setItem("someName");

        RegularItemDTO regularItemDTO = regularItemEntityTransformer.transform(regularItemEntity);
        assertNotNull(regularItemDTO);
        assertEquals(regularItemEntity.getItem(), regularItemDTO.getItem());
        assertEquals(regularItemEntity.getPrice(), regularItemDTO.getPrice(), 0);
        assertEquals(regularItemEntity.getSku(), regularItemDTO.getSku());
    }

}