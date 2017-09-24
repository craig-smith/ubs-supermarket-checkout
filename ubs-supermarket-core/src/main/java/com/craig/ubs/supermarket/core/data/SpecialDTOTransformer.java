package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import com.craig.ubs.supermarket.core.transformer.DTOTransformer;

public class SpecialDTOTransformer implements DTOTransformer<SpecialItemEntity, SpecialItemDTO> {


    @Override
    public SpecialItemEntity transform(SpecialItemDTO item) {

        SpecialItemEntity specialItemEntity = new SpecialItemEntity();
        specialItemEntity.setPrice(item.getPrice());
        specialItemEntity.setSku(item.getSku());
        specialItemEntity.setItem(item.getItem());
        specialItemEntity.setBuyAmount(item.getBuyAmount());
        specialItemEntity.setDiscountPrice(item.getDiscountPrice());

        return specialItemEntity;
    }
}
