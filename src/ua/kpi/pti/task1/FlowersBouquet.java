package ua.kpi.pti.task1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FlowersBouquet implements Goods {

    private List<Goods> parts = new ArrayList<>();

    @Override
    public BigDecimal getPrice() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Goods part: parts) {
            sum = sum.add(part.getPrice());
        }
        return sum;
    }

    @Override
    public GoodsType getType() {
        return GoodsType.BOUQUET;
    }

    public void add(Goods part) {
        if (part.getType() == GoodsType.FLOWER || part.getType() == GoodsType.ACCESSORY) {
            parts.add(part);
        } else {
            throw new IllegalArgumentException("Can't add to bouquet " + part.getType().toString());
        }
    }

    public int count(GoodsType type) {
        int result = 0;
        for (Goods part : parts) {
            if (part.getType() == type) {
                result++;
            }
        }

        return result;
    }


}
