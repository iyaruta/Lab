package ua.kpi.pti.lab5;

import org.junit.Test;
import ua.kpi.pti.lab4.MyLinkedList;
import ua.kpi.pti.lab7.MyList;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MyArrayListTest {

    @Test
    public void testNewList() throws Exception {
        MyArrayList myArrayList = new MyArrayList();
        assertEquals(0, myArrayList.size());
    }

    @Test
    public void add() throws Exception {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(4);
        myArrayList.add(9);
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void addEndList() throws Exception {
        MyArrayList myArrayList = new MyArrayList(2);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        assertEquals(4, myArrayList.capacity());
        assertEquals(3, myArrayList.size());
    }

    @Test
    public void get() throws Exception {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(9);
        myArrayList.add(2);
        assertEquals(1, myArrayList.get(0));
        assertEquals(9, myArrayList.get(1));
        assertEquals(2, myArrayList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFromEmptyList() throws Exception {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getBiggerThanSize() throws Exception {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(null);
        assertNull(myArrayList.get(0));
        myArrayList.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getBiggerThanCapacity() throws Exception {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.get(Integer.MAX_VALUE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLessThanZero() throws Exception {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.get(-1);
    }

    @Test
    public void remove() throws Exception {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        myArrayList.remove(1);
        assertEquals("c", myArrayList.get(1));
        assertEquals(3, myArrayList.size());
    }

    @Test
    public void removeFirst() throws Exception {
        MyArrayList myArrayList = new MyArrayList(4);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        Object removed = myArrayList.remove(0);
        assertEquals("a", removed);
        assertEquals("b", myArrayList.get(0));
        assertEquals("c", myArrayList.get(1));
        assertEquals("d", myArrayList.get(2));
        assertEquals(3, myArrayList.size());
    }

    @Test
    public void removeLast() throws Exception {
        MyArrayList myArrayList = new MyArrayList(4);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        Object removed = myArrayList.remove(3);
        assertEquals("d", removed);
        assertEquals("a", myArrayList.get(0));
        assertEquals("b", myArrayList.get(1));
        assertEquals("c", myArrayList.get(2));
        assertEquals(3, myArrayList.size());
    }

    @Test
    public void testSet() {
        MyArrayList list = new MyArrayList(1);
        list.add("a");
        list.set(0, "b");
        assertEquals("b", list.get(0));

        list.set(1, "c");
        list.set(-1, "d");
        assertEquals("b", list.get(0));
    }

    @Test
    public void testAddByIndex() throws Exception{
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add(1, "x");
        assertEquals("a", myArrayList.get(0));
        assertEquals("x", myArrayList.get(1));
        assertEquals("b", myArrayList.get(2));
        assertEquals("c", myArrayList.get(3));
        assertEquals(4, myArrayList.size());
    }

    @Test
    public void testAddToFirst() throws Exception{
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add(0, "x");
        assertEquals("x", myArrayList.get(0));
        assertEquals("a", myArrayList.get(1));
        assertEquals("b", myArrayList.get(2));
        assertEquals("c", myArrayList.get(3));
        assertEquals(4, myArrayList.size());
    }

    @Test
    public void testAddToEnd() throws Exception{
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add(2, "x");
        assertEquals("a", myArrayList.get(0));
        assertEquals("b", myArrayList.get(1));
        assertEquals("x", myArrayList.get(2));
        assertEquals("c", myArrayList.get(3));
        assertEquals(4, myArrayList.size());
    }

    @Test
    public void testAddAsLast() throws Exception{
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add(3, "x");
        assertEquals("a", myArrayList.get(0));
        assertEquals("b", myArrayList.get(1));
        assertEquals("c", myArrayList.get(2));
        assertEquals("x", myArrayList.get(3));
        assertEquals(4, myArrayList.size());
    }

    @Test
       public void addAsEndList() throws Exception {
        MyArrayList myArrayList = new MyArrayList(2);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add(1,"c");
        assertEquals(4, myArrayList.capacity());
        assertEquals(3, myArrayList.size());
        assertEquals("c", myArrayList.get(1));
    }

    @Test
    public void testEnsureCapacity() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        assertEquals(10, myArrayList.capacity());
        assertEquals(2, myArrayList.size());
        assertEquals("a", myArrayList.get(0));
        assertEquals("b", myArrayList.get(1));

        myArrayList.ensureCapacity(20);
        assertEquals(20, myArrayList.capacity());
        assertEquals(2, myArrayList.size());
        assertEquals("a", myArrayList.get(0));
        assertEquals("b", myArrayList.get(1));
    }

    @Test
    public void testEnsureCapacityLessOrigin() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        assertEquals(10, myArrayList.capacity());
        assertEquals(2, myArrayList.size());
        assertEquals("a", myArrayList.get(0));
        assertEquals("b", myArrayList.get(1));

        myArrayList.ensureCapacity(5);
        assertEquals(10, myArrayList.capacity());
        assertEquals(2, myArrayList.size());
        assertEquals("a", myArrayList.get(0));
        assertEquals("b", myArrayList.get(1));
    }

    @Test
    public void testAddArrayList() throws Exception {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.addAll(new Object[]{"x", "y", "z"});
        assertEquals("a", myArrayList.get(0));
        assertEquals("b", myArrayList.get(1));
        assertEquals("c", myArrayList.get(2));
        assertEquals("x", myArrayList.get(3));
        assertEquals("y", myArrayList.get(4));
        assertEquals("z", myArrayList.get(5));
        assertEquals(6, myArrayList.capacity());
    }

    @Test
    public void testAddAllEmpty() {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.addAll(new Object[]{});
        assertEquals("a", myArrayList.get(0));
        assertEquals("b", myArrayList.get(1));
        assertEquals("c", myArrayList.get(2));
        assertEquals(3, myArrayList.capacity());
    }

    @Test
    public void testAddIndexAll() {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.addAll(1, new Object[]{"x", "s"});
        assertEquals("a", myArrayList.get(0));
        assertEquals("x", myArrayList.get(1));
        assertEquals("s", myArrayList.get(2));
        assertEquals("b", myArrayList.get(3));
        assertEquals("c", myArrayList.get(4));
        assertEquals(6, myArrayList.capacity());
        assertEquals(5, myArrayList.size());
    }

    @Test
    public void testAddIndexAllFirst() {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.addAll(0, new Object[]{"x", "s"});
        assertEquals("x", myArrayList.get(0));
        assertEquals("s", myArrayList.get(1));
        assertEquals("a", myArrayList.get(2));
        assertEquals("b", myArrayList.get(3));
        assertEquals("c", myArrayList.get(4));
        assertEquals(6, myArrayList.capacity());
        assertEquals(5, myArrayList.size());
    }

    @Test
    public void testIterator() {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        Iterator it = myArrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            assertEquals(myArrayList.get(i), next);
            i++;
        }
    }

    @Test
    public void testIteratorRemove() {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        Iterator it = myArrayList.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        assertEquals(0, myArrayList.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testIteratorRemoveException() {
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add("a");
        Iterator it = myArrayList.iterator();
        it.remove();
    }

    @Test
    public void testIndexOf() {
        MyList list = new MyArrayList();
        list.add("s");
        list.add("f");
        list.add("d");
        list.add("a");

        assertEquals(-1, list.indexOf("x"));
        assertEquals(0, list.indexOf("s"));
        assertEquals(1, list.indexOf("f"));
        assertEquals(2, list.indexOf("d"));
        assertEquals(3, list.indexOf("a"));
    }

    @Test
    public void testToArray() {
        MyList list = new MyArrayList();
        list.add("s");
        list.add("f");
        list.add("d");
        list.add("a");
        Object[] array = list.toArray();
        assertEquals(4, array.length);
        assertArrayEquals(new String[]{"s", "f", "d", "a"}, array);
    }

}
