package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import com.craig.ubs.supermarket.core.transformer.ItemUpdater;

public class SpecialItemEntityUpdater implements ItemUpdater<SpecialItemEntity, SpecialItemDTO> {

    @Override
    public SpecialItemEntity updateItemEntity(SpecialItemEntity itemEntity, SpecialItemDTO itemDto) {
        itemEntity.setItem(itemDto.getItem());
        itemEntity.setPrice(itemDto.getPrice());
        itemEntity.setSku(itemDto.getSku());
        itemEntity.setBuyAmount(itemDto.getBuyAmount());
        itemEntity.setDiscountPrice(itemDto.getDiscountPrice());

        return itemEntity;
    }
}
