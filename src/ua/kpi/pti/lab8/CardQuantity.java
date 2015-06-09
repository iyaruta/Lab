package ua.kpi.pti.lab8;

public enum CardQuantity {

    FIVE(5), TEN(10), UNLIMITED(Integer.MAX_VALUE);

    private int quantity;

    CardQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
