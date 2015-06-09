package ua.kpi.pti.lab8;

import java.math.BigDecimal;
import java.util.Date;

public class DepositCard extends Card {

    private BigDecimal balance;

    public DepositCard(int id, BigDecimal balance) {
        super(id, CardType.GENERAL, new Date(Long.MAX_VALUE), 0);
        this.balance = balance;
    }

    public DepositCard(DepositCard card) {
        super(card);
        this.balance = card.getBalance();
    }

    @Override
    public void setQuantity(int quantity) {
        throw new UnsupportedOperationException("Quantity not supported for deposit card");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
