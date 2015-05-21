package ua.kpi.pti.lab5;

import ua.kpi.pti.lab6.MyCollections;

public class MyArrayList implements MyCollections {

    private Object[] array;
    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    public void add(Object e) {
        autoScale();
        array[size] = e;
        size++;
    }

    public void add(int index, Object e) {
        if (checkIndex(index) || index == size) {
            autoScale();
            int last = size - 1;
            while (index <= last) {
                array[last + 1] = array[last];
                last--;
            }
            array[index] = e;
            size++;
        }
    }

    public void addAll(Object[] e) {
        autoScale(e.length);
        System.arraycopy(e, 0, array, size, e.length);
        size += e.length;
    }

    public void addAll(int index, Object[] e) {
        if (checkIndex(index) || size == index) {
            autoScale(e.length);
            int last = size - 1;
            while (index <= last) {
                array[last + e.length] = array[last];
                last--;
            }
            System.arraycopy(e, 0, array, index, e.length);
            size += e.length;
        }
    }

    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        return array[index];
    }

    public Object remove(int index) {
        Object removed = null;
        if (checkIndex(index)) {
            removed = array[index];
            while (index < size - 1) {
                array[index] = array[++index];
            }
            array[index] = null;
            size--;
        }
        return removed;
    }


    public void set(int index, Object element) {
        if (checkIndex(index)) {
            array[index] = element;
        }
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            Object[] newArray = new Object[minCapacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    private boolean checkIndex(int index) {
        return index < size && index >= 0;
    }

    private void autoScale() {
        if (size == array.length ){
            ensureCapacity(array.length * 2);
        }
    }

    private void autoScale(int additional) {
        while (additional + size > array.length) {
            ensureCapacity(array.length * 2);
        }
    }

}
