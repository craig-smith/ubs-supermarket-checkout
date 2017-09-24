package com.craig.ubs.supermarket.core.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegularItemEntityTest {

    @Test
    public void testRegularItemEntity() {
        RegularItemEntity regularItemEntity = new RegularItemEntity();
        regularItemEntity.setSku("sku");
        regularItemEntity.setPrice(1.0);
        regularItemEntity.setItem("item");
        regularItemEntity.setId(1L);

        assertEquals("sku", regularItemEntity.getSku());
        assertEquals(1.0, regularItemEntity.getPrice(), 0 );
        assertEquals("item", regularItemEntity.getItem());
        assertEquals(1L, regularItemEntity.getId(), 0);
    }
}