package com.craig.ubs.supermarket.core.configuration;

import com.craig.ubs.supermarket.core.data.ItemEntityTransformerFactoryImpl;
import com.craig.ubs.supermarket.core.data.ItemUpdaterFactoryImpl;
import com.craig.ubs.supermarket.core.service.ItemSLO;
import com.craig.ubs.supermarket.core.service.ItemSLOBean;
import com.craig.ubs.supermarket.core.service.iface.SuperMarketScanner;
import com.craig.ubs.supermarket.core.supermarket.scanner.SuperMarketScannerImpl;
import com.craig.ubs.supermarket.core.transformer.DTOTransformerFactory;
import com.craig.ubs.supermarket.core.transformer.DTOTransformerFactoryImpl;
import com.craig.ubs.supermarket.core.transformer.ItemEntityTransformerFactory;
import com.craig.ubs.supermarket.core.transformer.ItemEntityUpdaterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ItemSLO getItemSLO() {
        return new ItemSLOBean();
    }

    @Bean
    public ItemEntityTransformerFactory getItemEntityTransformer() {
        return new ItemEntityTransformerFactoryImpl();
    }

    @Bean
    public DTOTransformerFactory getDTOTransformerFactory() {
        return new DTOTransformerFactoryImpl();
    }

    @Bean
    public ItemEntityUpdaterFactory getItemUpdaterFactory() {
        return new ItemUpdaterFactoryImpl();
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SuperMarketScanner getSupermarketScanner() {
        return new SuperMarketScannerImpl();
    }
}
