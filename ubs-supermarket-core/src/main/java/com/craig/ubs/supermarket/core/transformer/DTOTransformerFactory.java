package com.craig.ubs.supermarket.core.transformer;

import com.craig.ubs.supermarket.core.data.ItemEntity;
import com.craig.ubs.supermarket.core.service.iface.Item;

public interface DTOTransformerFactory {

    DTOTransformer<ItemEntity, Item> getTransformer(Item item);
}
