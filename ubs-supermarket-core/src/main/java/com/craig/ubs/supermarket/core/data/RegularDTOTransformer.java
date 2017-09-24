package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.transformer.DTOTransformer;

public class RegularDTOTransformer implements DTOTransformer<RegularItemEntity, RegularItemDTO> {

    @Override
    public RegularItemEntity transform(RegularItemDTO item) {
        RegularItemEntity regularItemEntity = new RegularItemEntity();
        regularItemEntity.setSku(item.getSku());
        regularItemEntity.setPrice(item.getPrice());
        regularItemEntity.setItem(item.getItem());

        return regularItemEntity;
    }
}
