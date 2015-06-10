package ua.kpi.pti.lab10;

import org.junit.Test;

import java.util.List;

public class GenericsTest {

    @Test
    public void test() {
        List<Fruit> fr = null;
        List<Apple> app = null;
        List<Orange> or = null;
        List<RedApple> rapp = null;
        List<Melon> mel = null;
        Generics.copyAll(or, fr);
        Generics.copyAll(rapp, fr);
        Generics.copyAll(rapp, app);
        Generics.copyAll(rapp, rapp);
//        Generics.copyAll(fr, or);
    }

    @Test
    public void testArray() {
        List<Fruit> fr = null;
        Orange[] or = null;
        Generics.fromArrayToCollection(or, fr);
    }



}
