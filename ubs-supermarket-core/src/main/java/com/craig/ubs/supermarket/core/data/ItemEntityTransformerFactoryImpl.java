package com.craig.ubs.supermarket.core.data;

import com.craig.ubs.supermarket.core.transformer.ItemEntityTransformer;
import com.craig.ubs.supermarket.core.transformer.ItemEntityTransformerFactory;
import com.craig.ubs.supermarket.core.transformer.RegularItemEntityTransformer;

/**
 * gets a relevant transformer for the given type
 */
public class ItemEntityTransformerFactoryImpl implements ItemEntityTransformerFactory {

    @Override
    public ItemEntityTransformer getTransformer(ItemEntity itemEntity) {
        if (itemEntity instanceof RegularItemEntity) {
            return new RegularItemEntityTransformer();
        } else if (itemEntity instanceof SpecialItemEntity) {
            return new SpecialItemEntityTransformer();
        } else {
            throw new IllegalArgumentException("No transform for type: " + itemEntity.getClass());
        }
    }
}
