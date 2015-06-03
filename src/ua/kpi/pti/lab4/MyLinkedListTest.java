package ua.kpi.pti.lab4;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * User: Alexandr
 * Date: 29.01.2015
 */
public class MyLinkedListTest {

    @Test
    public void removeFromEmptyList(){
        MyLinkedList list = new MyLinkedList();
        list.remove(0);

       assertEquals(0, list.size());
    }

    @Test
    public void removeByMinusIndex(){
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.remove(-1);

        assertEquals(1, list.size());
    }

    @Test
    public void removeByBigIndex(){
        MyLinkedList list = new MyLinkedList();
        list.add("D");
        list.add("a");
        list.add("w");
        list.add("q");

        assertEquals(4, list.size());
    }

    @Test
    public void removeFromMiddle(){
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("d");
        list.add("s");

        list.remove(1);
        assertEquals(2, list.size());
        assertTrue(list.contains("a"));
        assertTrue(list.contains("s"));
    }

    @Test
    public void removeFirs(){
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("s");
        list.add("e");

        list.remove(0);
        assertEquals(2, list.size());
        assertFalse(list.contains("a"));
        assertTrue(list.contains("s"));
    }

    @Test
    public void removeLast(){
        MyLinkedList list = new MyLinkedList();
        list.add("e");
        list.add("a");
        list.add("b");

        list.remove(2);
        assertFalse(list.contains("b"));
    }

    @Test
    public void removeOne(){
        MyLinkedList list = new MyLinkedList();
        list.add("e");

        list.remove(0);
        assertEquals(0, list.size());
        assertFalse(list.contains("e"));

    }

    @Test
    public void contains(){
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("d");
        list.add("s");

        assertTrue(list.contains("d"));
        list.remove(1);

        assertFalse(list.contains("d"));
        assertTrue(list.contains("a"));
        assertTrue(list.contains("s"));
    }

    @Test
    public void containsNot(){
        MyLinkedList list = new MyLinkedList();
        list.add("a");

        assertFalse(list.contains("o"));
    }

    @Test
    public void containsNotImportList(){
        MyLinkedList list = new MyLinkedList();
        assertFalse(list.contains("a"));
    }

    @Test
    public void containsNull(){
        MyLinkedList list = new MyLinkedList();
        assertFalse(list.contains(null));

        list.add("a");
        assertFalse(list.contains(null));

        list.add(null);
        assertTrue(list.contains(null));
    }

    @Test
    public void addOne(){
        MyLinkedList list = new MyLinkedList();
        list.add("a");

        assertEquals(1, list.size());
    }

    @Test
    public void addNull(){
        MyLinkedList list = new MyLinkedList();
        list.add(null);

        assertEquals(1, list.size());
    }

    @Test
    public void addMany(){
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("d");
        list.add("s");
        list.add("e");

        assertEquals(4, list.size());
    }

    @Test
    public void findOne(){
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("s");
        list.add("d");
        list.add("f");

        assertEquals(1, list.find("s"));
    }

    @Test
    public void findLust(){
        MyLinkedList list = new MyLinkedList();
        list.add("s");
        list.add("f");
        list.add("d");
        list.add("a");

        assertEquals(3, list.find("a"));
    }

    @Test
    public void listIterator(){
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("s");
        list.add("d");

        Iterator<String> ti = list.iterator();

        assertTrue(ti.hasNext());
        assertEquals("a", ti.next());

        assertTrue(ti.hasNext());
        assertEquals("s", ti.next());

        assertTrue(ti.hasNext());
        assertEquals("d", ti.next());

        assertFalse(null, ti.hasNext());
    }

    @Test
    public void unionAll(){
        MyLinkedList list1 = new MyLinkedList();
        list1.add("a");
        list1.add("s");

        MyLinkedList list2 = new MyLinkedList();

        list2.add("d");
        list2.add("f");
        list2.add("g");

        MyLinkedList unionList = list1.union(list2);
        assertEquals(5, unionList.size());
    }

    @Test
    public void intersectOne(){
        MyLinkedList list1 = new MyLinkedList();
        list1.add("a");
        list1.add("s");
        list1.add("d");

        MyLinkedList list2 = new MyLinkedList();
        list2.add("q");
        list2.add("w");
        list2.add("a");

        MyLinkedList ti = list1.intersect(list2);
        assertEquals(1, ti.size() );
    }

    @Test
    public void testAddAndGetFirst() {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.addFirst("z");
        assertEquals(2, list.size());
        assertEquals("z", list.getFirst());
    }

    @Test
    public void testAddAndGetLast() {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.addLast("z");
        assertEquals(2, list.size());
        assertEquals("z", list.getLast());
    }

    @Test
    public void testRemoveFirst() {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        String first1 = list.removeFirst();
        assertEquals("a", first1);
        assertEquals(0, list.size());

        list.add("x");
        list.add("y");
        String first2 = list.removeFirst();
        assertEquals(1, list.size());
        assertEquals("x", first2);
        assertEquals("y", list.getFirst());
        assertEquals("y", list.getLast());
    }

    @Test
    public void testRemoveLast() {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        String last1 = list.removeLast();
        assertEquals("a", last1);
        assertEquals(0, list.size());

        list.add("x");
        list.add("y");
        String last2 = list.removeLast();
        assertEquals("y", last2);
        assertEquals(1, list.size());
        assertEquals("x", list.getFirst());
        assertEquals("x", list.getLast());
    }

}
