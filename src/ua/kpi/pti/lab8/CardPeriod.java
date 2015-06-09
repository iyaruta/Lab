package ua.kpi.pti.lab8;

import java.util.Calendar;

public enum CardPeriod {

    TEN_DAYS(Calendar.DAY_OF_MONTH, 10), MONTH(Calendar.MONTH, 1);

    private int type;
    private int amount;

    CardPeriod(int type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public Calendar generate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(type, amount);
        return calendar;
    }

    public void add(Calendar calendar) {
        calendar.add(type, amount);
    }


}
