package com.craig.ubs.supermarket.web.application;

import com.craig.ubs.supermarket.core.service.ItemSLO;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class DataGenerator{

    @Autowired
    private ItemSLO itemSLO;

    @PostConstruct
    public void addTestData() {
        RegularItemDTO regularItemDTO = new RegularItemDTO.Builder()
                .withSku("123456")
                .withPrice(2.00)
                .withItem("Spoon")
                .build();

        RegularItemDTO regularItemDTO2 = new RegularItemDTO.Builder()
                .withSku("1234567")
                .withPrice(3.50)
                .withItem("Knife")
                .build();

        RegularItemDTO regularItemDTO3 = new RegularItemDTO.Builder()
                .withSku("12345678")
                .withPrice(4.00)
                .withItem("Plate")
                .build();

        RegularItemDTO regularItemDTO4 = new RegularItemDTO.Builder()
                .withSku("123456789")
                .withPrice(2.00)
                .withItem("Fork")
                .build();

        SpecialItemDTO specialItemDTO = new SpecialItemDTO.Builder() //2 for 6 or 1 for 4
                .withSku("1")
                .withPrice(4.00)
                .withItem("Place Mat")
                .withDiscountPrice(6.00)
                .withBuyAmount(2)
                .build();

        SpecialItemDTO specialItemDTO2 = new SpecialItemDTO.Builder() //3 for 8 or 1 for 3.50
                .withSku("12")
                .withPrice(3.50)
                .withItem("Wine Glass")
                .withDiscountPrice(8.00)
                .withBuyAmount(3)
                .build();

        SpecialItemDTO specialItemDTO3 = new SpecialItemDTO.Builder() //8 for 10 or 1 for 1.75
                .withSku("123")
                .withPrice(1.75)
                .withItem("Shot Glass")
                .withDiscountPrice(10)
                .withBuyAmount(8)
                .build();

        itemSLO.save(regularItemDTO);
        itemSLO.save(regularItemDTO2);
        itemSLO.save(regularItemDTO3);
        itemSLO.save(regularItemDTO4);

        itemSLO.save(specialItemDTO);
        itemSLO.save(specialItemDTO2);
        itemSLO.save(specialItemDTO3);
    }
}
