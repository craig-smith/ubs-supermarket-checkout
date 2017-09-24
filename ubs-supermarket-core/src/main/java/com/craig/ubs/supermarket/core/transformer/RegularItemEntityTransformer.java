package com.craig.ubs.supermarket.core.transformer;

import com.craig.ubs.supermarket.core.data.ItemEntity;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;

public class RegularItemEntityTransformer implements ItemEntityTransformer {

    @Override
    public RegularItemDTO transform(ItemEntity entity) {
        return new RegularItemDTO.Builder()
                .withItem(entity.getItem())
                .withPrice(entity.getPrice())
                .withSku(entity.getSku())
                .build();
    }
}
