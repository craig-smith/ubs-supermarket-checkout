package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import com.craig.ubs.supermarket.core.transformer.ItemEntityTransformer;

/**
 * transforms a SpecialItemEntity to a SpecialItemDTO
 */
public class SpecialItemEntityTransformer implements ItemEntityTransformer {

    @Override
    public SpecialItemDTO transform(ItemEntity entity) {
        SpecialItemEntity specialItemEntity = (SpecialItemEntity) entity;
        return new SpecialItemDTO.Builder()
                .withSku(specialItemEntity.getSku())
                .withPrice(specialItemEntity.getPrice())
                .withItem(specialItemEntity.getItem())
                .withDiscountPrice(specialItemEntity.getDiscountPrice())
                .withBuyAmount(specialItemEntity.getBuyAmount())
                .build();
    }
}
