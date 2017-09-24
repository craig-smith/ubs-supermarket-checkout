package com.craig.ubs.supermarket.core.service;


import com.craig.ubs.supermarket.core.service.iface.Item;

import java.util.List;

public interface ItemSLO {

    Item getBySKU(String sku);

    void save(Item item);

    void update(Item item);

    void delete(Item item);

    List<Item> getAll();

}
