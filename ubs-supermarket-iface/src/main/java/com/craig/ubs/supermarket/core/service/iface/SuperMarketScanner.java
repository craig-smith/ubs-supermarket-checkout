package com.craig.ubs.supermarket.core.service.iface;

public interface SuperMarketScanner {

    double addItem(String sku);

    double getTotalForItem(String sku);

    double getTotal();
}
