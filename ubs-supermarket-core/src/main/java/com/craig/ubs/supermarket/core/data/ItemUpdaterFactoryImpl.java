package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.service.iface.Item;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import com.craig.ubs.supermarket.core.transformer.ItemEntityUpdaterFactory;
import com.craig.ubs.supermarket.core.transformer.ItemUpdater;

/**
 * gets relevant itemUpdater for given ItemEntity and Item
 */
public class ItemUpdaterFactoryImpl implements ItemEntityUpdaterFactory {

    @Override
    public ItemUpdater getUpdater(ItemEntity entity, Item item) {
        if (entity instanceof RegularItemEntity && item instanceof RegularItemDTO) {
            return new RegularItemEntityUpdater();
        } else if (entity instanceof SpecialItemEntity && item instanceof SpecialItemDTO) {
            return new SpecialItemEntityUpdater();
        } else {
            throw new IllegalArgumentException("No updater for types: " + entity.getClass() + " " + item.getClass());
        }
    }
}
