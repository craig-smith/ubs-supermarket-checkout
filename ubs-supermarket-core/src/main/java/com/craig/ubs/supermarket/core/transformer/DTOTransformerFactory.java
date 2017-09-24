package com.craig.ubs.supermarket.core.transformer;

import com.craig.ubs.supermarket.core.service.iface.Item;

public interface DTOTransformerFactory {

    DTOTransformer getTransformer(Item item);
}
