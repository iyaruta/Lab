package ua.kpi.pti.lab8;

import java.util.Date;

public class Card {

    private final int id;
    private final CardType type;
    private final Date dueDate;
    private int quantity;

    public Card(int id, CardType type, Date dueDate, int quantity) {
        this.id = id;
        this.type = type;
        this.dueDate = dueDate;
        this.quantity = quantity;
    }

    public Card(Card card) {
        this.id = card.getId();
        this.type = card.getType();
        this.dueDate = card.getDueDate();
        this.quantity = card.getQuantity();
    }

    public int getId() {
        return id;
    }

    public CardType getType() {
        return type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
