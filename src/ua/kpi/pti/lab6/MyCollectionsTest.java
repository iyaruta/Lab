package ua.kpi.pti.lab6;

import org.junit.Test;
import ua.kpi.pti.lab4.MyLinkedList;
import ua.kpi.pti.lab5.MyArrayList;

import static org.junit.Assert.assertEquals;

public class MyCollectionsTest {

    @Test
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
    public void testCopyMyLinked() throws Exception {
        MyLinkedList src = new MyLinkedList();
        src.add("a");
        src.add("b");
        MyLinkedList dest = new MyLinkedList();
        dest.add("c");
        dest.add("c");
        dest.add("c");
        MyCollections.copy(dest, src);
        String[] expected = {"a", "b", "c"};
        int i = 0;
        for (String actual : dest) {
            assertEquals(expected[i], actual);
            i++;
        }
    }

    @Test
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
    public void testCopyMyArrayList() throws Exception {
        MyArrayList src = new MyArrayList();
        src.add("a");
        src.add("b");
        MyArrayList dest = new MyArrayList();
        dest.add("c");
        dest.add("c");
        dest.add("c");
        MyCollections.copy(dest, src);
        assertEquals("a", dest.get(0));
        assertEquals("b", dest.get(1));
        assertEquals("c", dest.get(2));
    }

    @Test
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

    @Test
    public void testBinarySearch() throws Exception {
        MyArrayList list = new MyArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        int index = MyCollections.binarySearch(list, 20);
        assertEquals(1, index);

        int missed = MyCollections.binarySearch(list, 25);
        assertEquals(-3, missed);
    }

}