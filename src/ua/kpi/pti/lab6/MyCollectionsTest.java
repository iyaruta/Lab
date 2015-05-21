package ua.kpi.pti.lab6;

import org.junit.Test;
import ua.kpi.pti.lab5.MyArrayList;

import static org.junit.Assert.*;

public class MyCollectionsTest {

    @Test
    public void testSort() throws Exception {

    }

    @Test
    public void testSwap() throws Exception {

    }

    @Test
    public void testCopy() throws Exception {

    }

    @Test
    public void testReverse() throws Exception {

    }

    @Test
    public void testSort1() throws Exception {

    }

    @Test
    public void testSwapMyArrayList() throws Exception {
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        MyCollections.swap(list, 1, 2);
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
        assertEquals("b", list.get(2));
        assertEquals("d", list.get(3));
    }

    @Test
    public void testCopy1() throws Exception {

    }

    @Test
    public void testReverse1() throws Exception {

    }
}