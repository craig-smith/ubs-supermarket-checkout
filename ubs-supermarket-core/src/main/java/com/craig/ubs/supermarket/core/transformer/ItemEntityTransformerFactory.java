package com.craig.ubs.supermarket.core.transformer;

import com.craig.ubs.supermarket.core.data.ItemEntity;

public interface ItemEntityTransformerFactory {
    ItemEntityTransformer getTransformer(ItemEntity itemEntity);
}
