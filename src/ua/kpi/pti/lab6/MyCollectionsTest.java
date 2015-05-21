package ua.kpi.pti.lab6;

import org.junit.Ignore;
import org.junit.Test;
import ua.kpi.pti.lab4.MyLinkedList;
import ua.kpi.pti.lab5.MyArrayList;

import static org.junit.Assert.*;

public class MyCollectionsTest {

    @Test
    @Ignore("not implemented yet")
    public void testSortMyLinked() throws Exception {
        MyLinkedList list = new MyLinkedList();
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("b");
        MyCollections.sort(list);
        String[] expected = {"a", "a", "b", "c"};
        int i = 0;
        for (String actual : list) {
            assertEquals(expected[i], actual);
            i++;
        }
    }

    @Test
    @Ignore("not implemented yet")
    public void testSwapMyLinked() throws Exception {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        MyCollections.swap(list, 1, 2);
        String[] expected = {"a", "c", "b", "d"};
        int i = 0;
        for (String actual : list) {
            assertEquals(expected[i], actual);
            i++;
        }
    }

    @Test
    @Ignore("not implemented yet")
    public void testCopyMyLinked() throws Exception {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("b");
        MyLinkedList dest = new MyLinkedList();
        dest.add("c");
        dest.add("c");
        dest.add("c");
        MyCollections.copy(list, dest);
        String[] expected = {"a", "b", "c"};
        int i = 0;
        for (String actual : dest) {
            assertEquals(expected[i], actual);
            i++;
        }
    }

    @Test
    @Ignore("not implemented yet")
    public void testReverseMyLinked() throws Exception {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        MyCollections.reverse(list);
        String[] expected = {"d", "c", "b", "a"};
        int i = 0;
        for (String actual : list) {
            assertEquals(expected[i], actual);
            i++;
        }
    }

    @Test
    @Ignore("not implemented yet")
    public void testSortMyArrayList() throws Exception {
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        MyCollections.sort(list);
        assertEquals("a", list.get(0));
        assertEquals("a", list.get(1));
        assertEquals("b", list.get(2));
        assertEquals("c", list.get(3));
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
    @Ignore("not implemented yet")
    public void testCopyMyArrayList() throws Exception {
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        MyArrayList dest = new MyArrayList();
        dest.add("c");
        dest.add("c");
        dest.add("c");
        MyCollections.copy(list, dest);
        assertEquals("a", dest.get(0));
        assertEquals("b", dest.get(1));
        assertEquals("c", dest.get(2));
    }

    @Test
    @Ignore("not implemented yet")
    public void testReverseMyArrayList() throws Exception {
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        MyCollections.reverse(list);
        assertEquals("d", list.get(0));
        assertEquals("c", list.get(1));
        assertEquals("b", list.get(2));
        assertEquals("a", list.get(3));
    }
}