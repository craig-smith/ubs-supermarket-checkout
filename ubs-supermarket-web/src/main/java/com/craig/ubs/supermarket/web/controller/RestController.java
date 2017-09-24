package com.craig.ubs.supermarket.web.controller;

import com.craig.ubs.supermarket.core.service.ItemSLO;
import com.craig.ubs.supermarket.core.service.iface.Item;
import com.craig.ubs.supermarket.core.service.iface.SuperMarketScanner;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import com.craig.ubs.supermarket.web.request.object.ItemRequestObject;
import com.craig.ubs.supermarket.web.request.object.ResponseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private ItemSLO itemSLO;

    @Autowired
    private SuperMarketScanner superMarketScanner;

    @GetMapping(value = "/links")
    public Map<String, String> getLinks(){
        Map<String, String> links = new HashMap<>();
        links.put("HOME", "/index");
        links.put("Checkout", "/checkout");
        return links;
    }

    @GetMapping(value = "/checkout/items")
    public List<Item> getAllItems() {
        return itemSLO.getAll();
    }

    @PostMapping(value = "/checkout/addItem")
    public double addItem(@RequestBody String sku) {
        return superMarketScanner.addItem(sku);
    }

    @GetMapping(value = "/checkout/total")
    public double getTotal() {
        return superMarketScanner.getTotal();
    }

    @PostMapping(value = "/checkout/totalforitem")
    public double getTotalForItem(@RequestBody String sku) {
        return superMarketScanner.getTotalForItem(sku);
    }

    @GetMapping(value = "/checkout/reset")
    public void resetCheckout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping(value = "/addItem")
    public ResponseItem addItem(@RequestBody ItemRequestObject itemRequestObject) {
        try {
        Item item;
        if(itemRequestObject.getDiscountPrice() > 0 && itemRequestObject.getBuyAmount() > 0) {

            item = new SpecialItemDTO.Builder()
                    .withItem(itemRequestObject.getItem())
                    .withPrice(itemRequestObject.getPrice())
                    .withSku(itemRequestObject.getSku())
                    .withBuyAmount(itemRequestObject.getBuyAmount())
                    .withDiscountPrice(itemRequestObject.getDiscountPrice())
                    .build();
        } else {
            item = new RegularItemDTO.Builder()
                    .withSku(itemRequestObject.getSku())
                    .withPrice(itemRequestObject.getPrice())
                    .withItem(itemRequestObject.getItem())
                    .build();
        }

            itemSLO.save(item);
        } catch (IllegalArgumentException ex) {

            ResponseItem responseItem = new ResponseItem();
            responseItem.setSuccess(false);
            responseItem.setMessage("Error creating item, please ensure all fields are set");
            return responseItem;

        } catch (DataIntegrityViolationException ex) {
            ResponseItem responseItem = new ResponseItem();
            responseItem.setSuccess(false);
            responseItem.setMessage("Error saving item, Make sure your SKU is unique");
            return responseItem;
        }

        ResponseItem responseItem = new ResponseItem();
        responseItem.setSuccess(true);
        responseItem.setMessage("Item saved");

        return responseItem;
    }

    @PostMapping(value = "/deleteItem")
    public ResponseItem deleteItem(@RequestBody String sku) {
        ResponseItem responseItem = new ResponseItem();
        Item item = itemSLO.getBySKU(sku);
        if( item != null ) {
            itemSLO.delete(item);
            responseItem.setSuccess(true);
            responseItem.setMessage("Item Deleted");
        } else {
            responseItem.setMessage("No such item");
            responseItem.setSuccess(false);
        }
        return responseItem;
    }
 }
