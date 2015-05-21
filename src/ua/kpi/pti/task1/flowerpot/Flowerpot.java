package ua.kpi.pti.task1.flowerpot;

import ua.kpi.pti.task1.AbstractGoods;
import ua.kpi.pti.task1.GoodsType;

public abstract class Flowerpot extends AbstractGoods {

    private String name;

    protected Flowerpot(String name) {
        super(GoodsType.FLOWERPOT);
        this.name = name;
    }
}
