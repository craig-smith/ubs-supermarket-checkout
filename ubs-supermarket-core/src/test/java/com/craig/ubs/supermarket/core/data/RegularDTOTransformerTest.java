package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.data.ItemEntity;
import com.craig.ubs.supermarket.core.data.RegularDTOTransformer;
import com.craig.ubs.supermarket.core.data.RegularItemEntity;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RegularDTOTransformerTest {

    private RegularDTOTransformer transformer = new RegularDTOTransformer();

    @Test
    public void transform() throws Exception {
        RegularItemDTO regularItemDTO = new RegularItemDTO.Builder()
                .withItem("item")
                .withPrice(2.00)
                .withSku("001")
                .build();

        ItemEntity itemEntity = transformer.transform(regularItemDTO);
        assertNotNull(itemEntity);
        assertEquals(regularItemDTO.getItem(), itemEntity.getItem());
        assertEquals(regularItemDTO.getPrice(), itemEntity.getPrice(), 0);
        assertEquals(regularItemDTO.getSku(), itemEntity.getSku());
        assertTrue(itemEntity instanceof RegularItemEntity);

    }

}