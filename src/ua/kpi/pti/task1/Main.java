package ua.kpi.pti.task1;

import ua.kpi.pti.task1.accessory.Card;
import ua.kpi.pti.task1.flower.Rose;

import java.math.BigDecimal;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        FlowersBouquet bouquet = new FlowersBouquet();
        for (int i = 0; i < 7; i++) {
            Rose rose = new Rose(BigDecimal.TEN, new Date());
            bouquet.add(rose);
        }

        Card card = new Card(BigDecimal.valueOf(15));
        bouquet.add(card);
        System.out.println(bouquet.count(GoodsType.FLOWER));
        System.out.println(bouquet.getPrice());
    }

}
