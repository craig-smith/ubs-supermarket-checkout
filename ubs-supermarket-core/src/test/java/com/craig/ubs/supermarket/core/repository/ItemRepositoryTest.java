package com.craig.ubs.supermarket.core.repository;

import com.craig.ubs.supermarket.core.data.EntityCreator;
import com.craig.ubs.supermarket.core.data.ItemEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testRepository() {

        itemRepository.save(EntityCreator.getRegularEntityForTest("item", "SKU", 2.00));

        ItemEntity item1 = itemRepository.findBySku("SKU");

        assertNotNull(item1);
    }

    @Test
    public void testSpecialItem() {

        itemRepository.save(EntityCreator.getSpecialItemEntityForTest("item", "1234", .50, 3, 1.00));

        ItemEntity item = itemRepository.findBySku("1234");

        assertNotNull(item);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSKUConstraing() {

        itemRepository.save(EntityCreator.getRegularEntityForTest("item", "1234", 1.00));
        itemRepository.save(EntityCreator.getRegularEntityForTest("item2", "1234", 1.50));
    }

}