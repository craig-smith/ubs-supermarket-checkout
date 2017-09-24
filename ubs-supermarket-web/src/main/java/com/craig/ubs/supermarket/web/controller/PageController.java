package com.craig.ubs.supermarket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PageController {

    @GetMapping(value = "/index")
    public String getIndex(Model model) {
        setLinks(model);

        return "index";
    }

    @GetMapping(value = "/checkout")
    public String getCheckout(Model model) {
       setLinks(model);

        return "checkout";
    }

    @GetMapping(value = "/addItems")
    public String getAddItems(Model model) {
        setLinks(model);
        return "addItems";
    }

    private void setLinks(Model model) {
        Map<String, String> links = new HashMap<>();
        links.put("HOME", "/index");
        links.put("Checkout", "/checkout");
        links.put("Edit Items", "/addItems");

        model.addAttribute("links", links);
    }

}
