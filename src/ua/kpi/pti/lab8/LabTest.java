package ua.kpi.pti.lab8;

import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LabTest {

    @After
    public void post() {
        Registry.getInstance().clear();
    }

    @Test
    public void testSchool() {
        Turnstile turnstile = new Turnstile(BigDecimal.valueOf(3));
        CardShop shop = new CardShop();
        Card school10 = shop.buySchool(CardPeriod.TEN_DAYS);
        Card school30 = shop.buySchool(CardPeriod.MONTH);

        boolean res10 = turnstile.submit(school10);
        boolean res30 = turnstile.submit(school30);
        assertTrue(res10);
        assertTrue(res30);

        Registry registry = Registry.getInstance();
        assertEquals(2, registry.getTotalAllowed());
        assertEquals(2, registry.getAllowed(CardType.SCHOOL));
    }

    @Test
    public void testStudent() {
        Turnstile turnstile = new Turnstile(BigDecimal.valueOf(3));
        CardShop shop = new CardShop();
        Card student10 = shop.buyStudent(CardPeriod.TEN_DAYS);
        Card student30 = shop.buyStudent(CardPeriod.MONTH);

        boolean res10 = turnstile.submit(student10);
        boolean res30 = turnstile.submit(student30);
        assertTrue(res10);
        assertTrue(res30);

        Registry registry = Registry.getInstance();
        assertEquals(2, registry.getTotalAllowed());
        assertEquals(2, registry.getAllowed(CardType.STUDENT));
    }

    @Test
    public void testGeneral() {
        Turnstile turnstile = new Turnstile(BigDecimal.valueOf(3));
        CardShop shop = new CardShop();

        Card card = shop.buyGeneral(CardPeriod.TEN_DAYS, CardQuantity.FIVE);
        for (int i = 0; i < 7; i++) {
            turnstile.submit(card);
        }

        Registry registry = Registry.getInstance();
        assertEquals(5, registry.getTotalAllowed());
        assertEquals(2, registry.getTotalDenied());
        assertEquals(0, card.getQuantity());
    }

    @Test
    public void testDeposit() {
        Turnstile turnstile = new Turnstile(BigDecimal.valueOf(3));
        CardShop shop = new CardShop();

        DepositCard card = shop.buyDeposit(BigDecimal.TEN);
        for (int i = 0; i < 7; i++) {
            turnstile.submit(card);
        }

        Registry registry = Registry.getInstance();
        assertEquals(3, registry.getTotalAllowed());
        assertEquals(4, registry.getTotalDenied());
        assertEquals(BigDecimal.ONE, card.getBalance());
    }

}
