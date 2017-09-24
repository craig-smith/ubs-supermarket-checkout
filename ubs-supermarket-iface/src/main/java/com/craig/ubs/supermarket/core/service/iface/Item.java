package com.craig.ubs.supermarket.core.service.iface;
/**
 * DTO's implement this interface to give different way of calculating total price per item
 */
import java.util.function.Function;

public interface Item {

    String getSku();

    String getItem();

    Double getPrice();

    Function<Integer, Double> getTotalForItemFunction();

}
