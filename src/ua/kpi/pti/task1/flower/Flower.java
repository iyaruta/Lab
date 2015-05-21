package ua.kpi.pti.task1.flower;

import ua.kpi.pti.task1.AbstractGoods;
import ua.kpi.pti.task1.GoodsType;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Flower extends AbstractGoods {

    private Integer length;
    private Date date; //когда завянет

    protected Flower(BigDecimal price, Date date, Integer length) {
        super(GoodsType.FLOWER, price);
        this.date = date;
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

    public Date getDate() {
        return date;
    }
}
