package ua.kpi.pti.lab8;


import java.math.BigDecimal;

public class CardShop {

    private Registry registry = Registry.getInstance();

    public Card buyStudent(CardPeriod days) {
        return registry.buy(CardType.STUDENT, days, CardQuantity.UNLIMITED);
    }

    public Card buySchool(CardPeriod days) {
        return registry.buy(CardType.SCHOOL, days, CardQuantity.UNLIMITED);
    }

    public Card buyGeneral(CardPeriod days, CardQuantity quantity) {
        return registry.buy(CardType.GENERAL, days, quantity);
    }

    public DepositCard buyDeposit(BigDecimal balance) {
        return registry.buyDeposit(balance);
    }

    public void refill(DepositCard card, BigDecimal balance) {


    }

}
