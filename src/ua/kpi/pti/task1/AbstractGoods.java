package ua.kpi.pti.task1;

import java.math.BigDecimal;

public abstract class AbstractGoods implements Goods {

    private final GoodsType type;
    private BigDecimal price;

    protected AbstractGoods(GoodsType type) {
        this.type = type;
    }

    protected AbstractGoods(GoodsType type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public GoodsType getType() {
        return type;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
