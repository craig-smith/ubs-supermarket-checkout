package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.transformer.ItemUpdater;

/**
 * updates an ItemEntity with new values from an ItemDTO
 */
public class RegularItemEntityUpdater implements ItemUpdater<RegularItemEntity, RegularItemDTO> {

    @Override
    public RegularItemEntity updateItemEntity(RegularItemEntity itemEntity, RegularItemDTO itemDto) {
        itemEntity.setItem(itemDto.getItem());
        itemEntity.setPrice(itemDto.getPrice());
        itemEntity.setSku(itemDto.getSku());

        return itemEntity;
    }
}
