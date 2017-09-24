package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialDTOTransformerTest {

    private SpecialDTOTransformer specialDTOTransformer = new SpecialDTOTransformer();

    @Test
    public void transform() throws Exception {
        SpecialItemDTO specialItemDTO = new SpecialItemDTO.Builder()
                .withItem("item")
                .withSku("sku")
                .withPrice(1.00)
                .withBuyAmount(2)
                .withDiscountPrice(1.50)
                .build();

        SpecialItemEntity specialItemEntity = specialDTOTransformer.transform(specialItemDTO);
    }

}