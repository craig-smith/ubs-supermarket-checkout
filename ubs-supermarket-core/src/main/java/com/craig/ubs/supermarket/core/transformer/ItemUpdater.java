package com.craig.ubs.supermarket.core.transformer;

import com.craig.ubs.supermarket.core.data.ItemEntity;
import com.craig.ubs.supermarket.core.service.iface.Item;

public interface ItemUpdater<T extends ItemEntity, U extends Item> {

    T updateItemEntity(T itemEntity, U item);
}
