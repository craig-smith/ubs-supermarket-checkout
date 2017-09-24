package com.craig.ubs.supermarket.core.transformer;

import com.craig.ubs.supermarket.core.data.ItemEntity;
import com.craig.ubs.supermarket.core.service.iface.Item;

public interface ItemEntityTransformer {

    Item transform(ItemEntity entity);
}
