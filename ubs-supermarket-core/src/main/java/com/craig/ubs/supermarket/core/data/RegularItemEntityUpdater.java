package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.Item;
import com.craig.ubs.supermarket.core.transformer.ItemUpdater;

/**
 * updates an ItemEntity with new values from an ItemDTO
 */
public class RegularItemEntityUpdater implements ItemUpdater<RegularItemEntity, Item> {

    @Override
    public RegularItemEntity updateItemEntity(RegularItemEntity itemEntity, Item itemDto) {
        itemEntity.setItem(itemDto.getItem());
        itemEntity.setPrice(itemDto.getPrice());
        itemEntity.setSku(itemDto.getSku());

        return itemEntity;
    }
}
