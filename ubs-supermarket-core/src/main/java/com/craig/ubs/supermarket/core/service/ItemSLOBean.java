package com.craig.ubs.supermarket.core.service;


import com.craig.ubs.supermarket.core.data.ItemEntity;
import com.craig.ubs.supermarket.core.repository.ItemRepository;
import com.craig.ubs.supermarket.core.service.iface.Item;
import com.craig.ubs.supermarket.core.transformer.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * implementation for ItemSLO
 *
 * all work with entities must go through this class {ENTITIES are package private and cannot be created/updated outside}
 */
public class ItemSLOBean implements ItemSLO {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemEntityTransformerFactory transformerFactory;

    @Autowired
    private DTOTransformerFactory dtoTransformerFactory;

    @Autowired
    private ItemEntityUpdaterFactory itemUpdaterFactory;

    @Override
    public Item getBySKU(String sku) {
        ItemEntity item = itemRepository.findBySku(sku);

        if(item != null) {
            ItemEntityTransformer transformer = transformerFactory.getTransformer(item);
            return transformer.transform(item);
        } else {
            return null;
        }

    }

    @Override
    public List<Item> getAll() {
        List<ItemEntity> entities = itemRepository.findAll();

        return entities.stream().map(transformerFunction).collect(Collectors.toList());
    }

    private Function<ItemEntity, Item> transformerFunction = new Function<ItemEntity, Item>() {
        @Override
        public Item apply(ItemEntity entity) {
           ItemEntityTransformer transformer = transformerFactory.getTransformer(entity);
           return transformer.transform(entity);
        }
    };

    @Override
    public void save(Item item) {
        DTOTransformer dtoTransformer = dtoTransformerFactory.getTransformer(item);
        ItemEntity itemEntity = dtoTransformer.transform(item);

        itemRepository.save(itemEntity);
    }


    @Override
    public void update(Item item) {
        ItemEntity itemEntity = itemRepository.findBySku(item.getSku());
        ItemUpdater updater = itemUpdaterFactory.getUpdater(itemEntity, item);
        updater.updateItemEntity(itemEntity, item);

        itemRepository.save(itemEntity);

    }

    @Override
    public void delete(Item item) {
        ItemEntity itemEntity = itemRepository.findBySku(item.getSku());
        if (item != null) {
            itemRepository.delete(itemEntity);
        }

    }

}
