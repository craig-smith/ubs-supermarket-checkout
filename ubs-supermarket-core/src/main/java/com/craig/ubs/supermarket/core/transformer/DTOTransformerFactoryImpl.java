package com.craig.ubs.supermarket.core.transformer;

import com.craig.ubs.supermarket.core.data.RegularDTOTransformer;
import com.craig.ubs.supermarket.core.data.SpecialDTOTransformer;
import com.craig.ubs.supermarket.core.service.iface.Item;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;

public class DTOTransformerFactoryImpl implements DTOTransformerFactory {

    @Override
    public DTOTransformer getTransformer(Item item) {
        if (item instanceof RegularItemDTO) {
            return new RegularDTOTransformer();
        } else if (item instanceof SpecialItemDTO) {
            return new SpecialDTOTransformer();
        } else {
            throw new IllegalArgumentException("No transformer for type: " + item.getClass());
        }
    }
}
