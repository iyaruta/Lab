package ua.kpi.pti.lab5;

import java.util.Iterator;

public class MyArrayList implements Iterable {

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

    @Override
    public Iterator iterator() {
        return new MyArrayListIterator();
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

    private class MyArrayListIterator implements Iterator {

        private int index = -1;

        @Override
        public boolean hasNext() {
            return index < size - 1;
        }

        @Override
        public Object next() {
            index++;
            return array[index];
        }

        @Override
        public void remove() {
            if (!checkIndex(index)) {
                throw new IllegalStateException();
            }

            MyArrayList.this.remove(index);
            index--;
        }
    }

}
