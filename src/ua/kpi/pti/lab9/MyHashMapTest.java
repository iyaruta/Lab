package ua.kpi.pti.lab9;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void testClear() throws Exception {
        MyMap map = new MyHashMap();
        map.put("a", "x");
        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    public void testContainsKey() throws Exception {
        MyMap map = new MyHashMap();
        map.put("a", "x");
        assertTrue(map.containsKey("a"));
        assertFalse(map.containsKey("x"));
    }

    @Test
    public void testContainsValue() throws Exception {
        MyMap map = new MyHashMap();
        map.put("a", "x");
        assertTrue(map.containsValue("x"));
        assertFalse(map.containsValue("a"));
    }

    @Test
    public void testGet() throws Exception {
        MyMap map = new MyHashMap();
        map.put("a", "x");
        Object a = map.get("a");
        Object b = map.get("b");
        assertEquals("x", a);
        assertNull(b);
    }

    @Test
    public void testIsEmpty() throws Exception {
        MyMap map = new MyHashMap();
        assertTrue(map.isEmpty());

        map.put("a", "b");
        assertFalse(map.isEmpty());
    }

    @Test
    public void testPut() throws Exception {
        MyMap map = new MyHashMap();
        Object oldValue0 = map.put("a", "x");
        Object oldValue1 = map.put("a", "y");
        Object oldValue2 = map.put("a", "z");
        map.put("b", "x");

        assertNull(oldValue0);
        assertEquals("x", oldValue1);
        assertEquals("y", oldValue2);
        assertEquals(2, map.size());
    }

    @Test
    public void testRemove() throws Exception {
        MyMap map = new MyHashMap();
        map.put("a", "x");
        map.put("b", "y");

        map.remove("a");

        assertEquals(1, map.size());
        assertNull(map.get("a"));
        assertEquals("y", map.get("b"));
    }

    @Test
    public void testIterator() throws Exception {
        MyMap map = new MyHashMap();
        map.put("a", "x");
        map.put("b", "y");

        String[] res = {"b", "a"};
        Iterator iterator = map.entryIterator();
        int i = 0;
        while (iterator.hasNext()) {
            MyMap.Entry next = (MyMap.Entry)iterator.next();
            assertEquals(res[0], next.getKey());
            i++;
        }

    }


}