package com.craig.ubs.supermarket.core.transformer;

import com.craig.ubs.supermarket.core.data.ItemEntity;
import com.craig.ubs.supermarket.core.service.iface.Item;

public interface DTOTransformer<S extends ItemEntity, T extends Item> {

    S transform(T item);
}
