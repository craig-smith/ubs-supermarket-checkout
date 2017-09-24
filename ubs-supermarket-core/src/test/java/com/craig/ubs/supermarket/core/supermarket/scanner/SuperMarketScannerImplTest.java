package com.craig.ubs.supermarket.core.supermarket.scanner;

import com.craig.ubs.supermarket.core.configuration.Configuration;
import com.craig.ubs.supermarket.core.service.ItemSLO;
import com.craig.ubs.supermarket.core.service.iface.SuperMarketScanner;
import com.craig.ubs.supermarket.core.service.iface.dto.item.RegularItemDTO;
import com.craig.ubs.supermarket.core.service.iface.dto.item.SpecialItemDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@Import(Configuration.class)
public class SuperMarketScannerImplTest {

    @Autowired
    private SuperMarketScanner superMarketScanner;

    @Autowired
    private ItemSLO itemSLO;

    @Before
    public void setUp(){
        RegularItemDTO regularItemDTO = new RegularItemDTO.Builder()
                .withItem("")
                .withPrice(5.00)
                .withSku("1")
                .build();

        RegularItemDTO regularItemDTO2 = new RegularItemDTO.Builder()
                .withItem("")
                .withPrice(10.00)
                .withSku("2")
                .build();

        SpecialItemDTO specialItemDTO = new SpecialItemDTO.Builder()
                .withItem("")
                .withPrice(5.00)
                .withSku("3")
                .withBuyAmount(4)
                .withDiscountPrice(15)
                .build();

        SpecialItemDTO specialItemDTO2 = new SpecialItemDTO.Builder()
                .withItem("")
                .withPrice(5.00)
                .withSku("4")
                .withBuyAmount(5)
                .withDiscountPrice(20)
                .build();

        itemSLO.save(regularItemDTO);
        itemSLO.save(regularItemDTO2);
        itemSLO.save(specialItemDTO);
        itemSLO.save(specialItemDTO2);
    }

    @Test
    public void addItem() throws Exception {

        superMarketScanner.addItem("1");
        superMarketScanner.addItem("2");

    }

    @Test
    public void getTotal() throws Exception {
        superMarketScanner.addItem("1");
        superMarketScanner.addItem("2");

        double total = superMarketScanner.getTotal();
        //10 + 5 = 15
        assertEquals(15, total, 0);

        superMarketScanner.addItem("3");
        superMarketScanner.addItem("3");
        superMarketScanner.addItem("3");
        superMarketScanner.addItem("3"); //times four should be discounted price

        double total2 = superMarketScanner.getTotal();
        //10 + 5 + 15 = 30
        assertEquals(30, total2, 0);
    }

    @Test
    public void getTotalForItem() throws Exception {
        superMarketScanner.addItem("1");
        superMarketScanner.addItem("1");

        superMarketScanner.addItem("3");
        superMarketScanner.addItem("3");
        superMarketScanner.addItem("3");
        superMarketScanner.addItem("3");

        superMarketScanner.addItem("4");
        superMarketScanner.addItem("4");
        superMarketScanner.addItem("4");
        superMarketScanner.addItem("4");
        superMarketScanner.addItem("4");
        superMarketScanner.addItem("4");

        double totalForItem1 = superMarketScanner.getTotalForItem("1"); //2 regular at 5 each
        assertEquals(10, totalForItem1, 0);

        double totalForItem3 = superMarketScanner.getTotalForItem("3"); //4 for 15
        assertEquals(15, totalForItem3, 0);

        double totalForItem4 = superMarketScanner.getTotalForItem("4");//5 for 20 plus 1 for 5
        assertEquals(25, totalForItem4, 0);


    }

}