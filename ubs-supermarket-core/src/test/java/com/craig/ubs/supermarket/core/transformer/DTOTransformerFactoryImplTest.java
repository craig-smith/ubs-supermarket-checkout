package com.craig.ubs.supermarket.core.transformer;

import com.craig.ubs.supermarket.core.data.RegularDTOTransformer;
import com.craig.ubs.supermarket.core.data.SpecialDTOTransformer;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class DTOTransformerFactoryImplTest {

    DTOTransformerFactory dtoTransformerFactory = new DTOTransformerFactoryImpl();

    @Test
    public void getTransformer() throws Exception {
        RegularItemDTO regularItemDTO = new RegularItemDTO.Builder()
                .withItem("item")
                .withPrice(2.00)
                .withSku("001")
                .build();
        DTOTransformer dtoTransformer = dtoTransformerFactory.getTransformer(regularItemDTO);
        assertNotNull(dtoTransformer);
        assertTrue(dtoTransformer instanceof RegularDTOTransformer);

        SpecialItemDTO specialItemDTO = new SpecialItemDTO.Builder()
                .withItem("newItem")
                .withPrice(2.00)
                .withSku("1234")
                .withBuyAmount(5)
                .withBuyAmount(4)
                .build();
        DTOTransformer dtoTransformer2 = dtoTransformerFactory.getTransformer(specialItemDTO);
        assertNotNull(dtoTransformer2);
        assertTrue(dtoTransformer2 instanceof SpecialDTOTransformer);
    }

}