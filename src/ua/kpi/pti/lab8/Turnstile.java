package ua.kpi.pti.lab8;

import java.math.BigDecimal;

public class Turnstile {

    private Registry registry = Registry.getInstance();
    private BigDecimal price;

    public Turnstile(BigDecimal price) {
        this.price = price;
    }

    public boolean submit(Card card) {
        if (card instanceof DepositCard) {
            DepositCard depositCard = (DepositCard) card;
            return registry.submit(depositCard, price);
        } else {
            return registry.submit(card);
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
