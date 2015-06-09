package ua.kpi.pti.lab8;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Registry {

    private static final Registry _instance = new Registry();
    private final Map<Integer, Card> DB = new HashMap<>();
    private final Map<CardType, Integer> allowed = new HashMap<>();
    private final Map<CardType, Integer> denied = new HashMap<>();
    private int lastNumber;

    private Registry() {

    }

    public static Registry getInstance() {
        return _instance;
    }

    public Card buy(CardType type, CardPeriod period, CardQuantity quantity) {
        Calendar dueDate = period.generate();
        int qty = quantity.getQuantity();
        lastNumber++;
        Card card = new Card(lastNumber, type, dueDate.getTime(), qty);
        DB.put(lastNumber, new Card(card)); //что бы объект в регистре не менялся при изменении карты
        return card;
    }

    public DepositCard buyDeposit(BigDecimal balance) {
        lastNumber++;
        DepositCard depositCard = new DepositCard(lastNumber, balance);
        DB.put(lastNumber, new DepositCard(depositCard));
        return depositCard;
    }

    public boolean submit(Card obj) {
        Calendar now = Calendar.getInstance();
        Card card = DB.get(obj.getId());
        Date dueDate = card.getDueDate();
        int qty = card.getQuantity();
        if (dueDate.compareTo(now.getTime()) == -1 || qty <= 0) {
            deny(card);
            return false;
        }

        qty--;
        obj.setQuantity(qty);
        card.setQuantity(qty);
        allow(card);
        return true;
    }

    public boolean submit(DepositCard depositCard, BigDecimal price) {
        DepositCard card = (DepositCard)DB.get(depositCard.getId());
        BigDecimal balance = card.getBalance();
        boolean result = false;
        if (balance.compareTo(price) >= 0) {
            BigDecimal newBalance = balance.subtract(price);
            card.setBalance(newBalance);
            depositCard.setBalance(newBalance);
            result = true;
            allow(card);
        }

        if (!result) {
            deny(card);
        }

        return result;
    }

    public int getTotalAllowed() {
        return total(allowed);
    }

    public int getTotalDenied() {
        return total(denied);
    }

    public int getAllowed(CardType type) {
        return total(allowed, type);
    }

    public int getDenied(CardType type) {
        return total(denied, type);
    }

    public void clear() {
        allowed.clear();
        denied.clear();
    }

    private int total(Map<CardType, Integer> map) {
        int result = 0;
        for (Integer qty : map.values()) {
            result += qty;
        }
        return result;
    }

    private int total(Map<CardType, Integer> map, CardType type) {
        Integer qty = map.get(type);
        return qty == null ? 0 : qty;
    }

    private void allow(Card card) {
        log(card, allowed);
    }

    private void deny(Card card) {
        log(card, denied);
    }

    private void log(Card card, Map<CardType, Integer> map) {
        Integer qty = map.get(card.getType());
        if (qty == null) {
            qty = 0;
        }
        qty++;
        map.put(card.getType(), qty);
    }

}
