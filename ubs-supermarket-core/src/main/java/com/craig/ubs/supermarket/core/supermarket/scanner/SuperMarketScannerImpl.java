package com.craig.ubs.supermarket.core.supermarket.scanner;

import com.craig.ubs.supermarket.core.service.ItemSLO;
import com.craig.ubs.supermarket.core.service.iface.Item;
import com.craig.ubs.supermarket.core.service.iface.SuperMarketScanner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of SuperMarketScanner
 */
public class SuperMarketScannerImpl implements SuperMarketScanner {

    @Autowired
    private ItemSLO itemSLO;

    private List<Item> cartItems = new ArrayList<>();

    @Override
    public synchronized double addItem(String sku) {
        Item item = itemSLO.getBySKU(sku);
        if (item != null) {
            cartItems.add(item);
            return item.getPrice();
        } else {
            return 0;
        }
    }

    @Override
    public synchronized double getTotal() {
        Map<String, List<Item>> sortedItems = cartItems.stream()
                .collect(Collectors.groupingBy(Item::getSku));

        double total = sortedItems.entrySet().stream()
                .mapToDouble(itemEntry -> getTotalForItem(itemEntry.getValue().get(0), itemEntry.getValue().size()))
                .sum();

        return total;
    }

    @Override
    public synchronized double getTotalForItem(String sku) {
        List<Item> items = cartItems.stream().filter( e -> e.getSku().equals(sku)).collect(Collectors.toList());
        if(items.size() > 0) {
            return getTotalForItem(items.get(0), items.size());
        } else {
            return 0;
        }

    }

    private double getTotalForItem(Item item, int count) {
        return item.getTotalForItemFunction().apply(count);
    }
}
