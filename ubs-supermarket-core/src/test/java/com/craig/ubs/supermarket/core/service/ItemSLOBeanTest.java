package com.craig.ubs.supermarket.core.service;

import com.craig.ubs.supermarket.core.configuration.Configuration;
import com.craig.ubs.supermarket.core.data.EntityCreator;
import com.craig.ubs.supermarket.core.data.ItemEntity;
import com.craig.ubs.supermarket.core.repository.ItemRepository;
import com.craig.ubs.supermarket.core.service.iface.Item;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@Import(Configuration.class)
public class ItemSLOBeanTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemSLO itemSLO;

    @Test
    public void getBySKU() throws Exception {

        itemRepository.save(EntityCreator.getRegularEntityForTest("someName", "SKU", 1.00));

        Item item = itemSLO.getBySKU("SKU");

        assertNotNull(item);

        itemRepository.save(EntityCreator.getSpecialItemEntityForTest("item", "123", 1.00, 4, 3.00));

        Item item1 = itemSLO.getBySKU("123");
        assertNotNull(item1);

    }

    @Test
    public void testUpdate(){

        itemRepository.save(EntityCreator.getSpecialItemEntityForTest("item", "1234", 1.00, 2, 3.00));

        SpecialItemDTO specialItemDTOUpdate = new SpecialItemDTO.Builder()
                .withItem("newItem")
                .withPrice(2.00)
                .withSku("1234")
                .withBuyAmount(5)
                .withBuyAmount(4)
                .build();

        itemSLO.update(specialItemDTOUpdate);

        SpecialItemDTO item = (SpecialItemDTO) itemSLO.getBySKU("1234");

        assertEquals(specialItemDTOUpdate.getBuyAmount(), item.getBuyAmount());
        assertEquals(specialItemDTOUpdate.getDiscountPrice(), item.getDiscountPrice(), 0);


        itemRepository.save(EntityCreator.getRegularEntityForTest("item", "001", 1.00));

        RegularItemDTO regularItemDTO = new RegularItemDTO.Builder()
                .withItem("item")
                .withPrice(2.00)
                .withSku("001")
                .build();
        itemSLO.update(regularItemDTO);

        ItemEntity itemEntity = itemRepository.findBySku("001");

        assertEquals(itemEntity.getPrice(), regularItemDTO.getPrice(), 0);
    }

    @Test
    public void testDelete() {

        itemRepository.save(EntityCreator.getSpecialItemEntityForTest("item", "123456", 1.00, 2, 1.5));

        Item item = itemSLO.getBySKU("123456");

        itemSLO.delete(item);

        ItemEntity deletedItem = itemRepository.findBySku("123456");
        assertNull(deletedItem);
    }

}