package ua.kpi.pti.task1.accessory;

import ua.kpi.pti.task1.AbstractGoods;
import ua.kpi.pti.task1.GoodsType;

import java.math.BigDecimal;

public abstract class Accessory extends AbstractGoods {

    private String name;

    public Accessory(BigDecimal price, String name) {
        super(GoodsType.ACCESSORY, price);
        this.name = name;
    }
}
