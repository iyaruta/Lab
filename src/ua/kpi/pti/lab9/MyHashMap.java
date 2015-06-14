package ua.kpi.pti.lab9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MyHashMap implements MyMap {

    private ArrayList<SimpleEntry>[] entries;
    private int size;

    private int initialCapacity;
    private float loadFactor;
    private int threshold;

    public MyHashMap() {
        this(16, 0.75f);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0 || loadFactor <= 0) {
            throw new IllegalArgumentException();
        }

        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;

        entries = new ArrayList[initialCapacity];
        threshold = calcThreshold(loadFactor);
    }

    @Override
    public void clear() {
        entries = new ArrayList[initialCapacity];
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        List<SimpleEntry> entryList = getEntryList(key);
        for (SimpleEntry entry : entryList) {
            if (Objects.equals(key, entry.getKey())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (ArrayList<SimpleEntry> entryList : entries) {
            if (entryList != null) {
                for (SimpleEntry entry : entryList) {
                    if (Objects.equals(value, entry.getValue())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public Object get(Object key) {
        List<SimpleEntry> entryList = getEntryList(key);
        for (SimpleEntry entry : entryList) {
            if (Objects.equals(key, entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object put(Object key, Object value) {
        List<SimpleEntry> entryList = getEntryList(key);
        for (SimpleEntry simpleEntry : entryList) {
            if (key.equals(simpleEntry.getKey())) {
                return simpleEntry.setValue(value);
            }
        }

        SimpleEntry entry = new SimpleEntry(key, value);
        entryList.add(entry);
        size++;
        if (size > threshold) {
            extend();
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        Object value = get(key);
        if (value != null) {
            List<SimpleEntry> entryList = getEntryList(key);
            SimpleEntry entry = new SimpleEntry(key, value);
            boolean removed = entryList.remove(entry);
            if (removed) {
                size--;
            }
        }

        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator entryIterator() {
        return new HashIterator();
    }

    private int indexOf(Object obj) {
        int hash = obj.hashCode();
        hash %= entries.length;
        if (hash < 0) {
            hash *= -1;
        }

        return hash;
    }

    private List<SimpleEntry> getEntryList(Object key) {
        int bucket = indexOf(key);
        ArrayList<SimpleEntry> entryList = entries[bucket];
        if (entryList == null) {
            entryList = new ArrayList<>();
            entries[bucket] = entryList;
        }

        return entryList;
    }

    private int calcThreshold(float loadFactor) {
        return (int)(entries.length * loadFactor);
    }

    private void extend() {
        ArrayList<SimpleEntry>[] old = entries;
        entries = new ArrayList[old.length * 2];
        for (ArrayList<SimpleEntry> entryList : old) {
            if (entryList != null) {
                for (SimpleEntry entry : entryList) {
                    put(entry.key, entry.value);
                }
            }
        }

        threshold = calcThreshold(loadFactor);
    }

    private class SimpleEntry implements Entry {

        private Object key;
        private Object value;

        private SimpleEntry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            Object oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SimpleEntry that = (SimpleEntry) o;

            if (key != null ? !key.equals(that.key) : that.key != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }
    }

    private class HashIterator implements Iterator {

        Iterator<SimpleEntry> bucketIterator;
        SimpleEntry next;
        int bucketIndex = -1;

        private HashIterator() {
            for (ArrayList<SimpleEntry> entryList : entries) {
                bucketIndex++;
                if (entryList != null && !entryList.isEmpty()) {
                    bucketIterator = entryList.iterator();
                    next = bucketIterator.next();
                }
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public SimpleEntry next() {
            SimpleEntry result = next;
            if (!bucketIterator.hasNext()) {
                bucketIndex++;
                for (int i = bucketIndex; i < entries.length; i++) {
                    ArrayList<SimpleEntry> entryList = entries[i];
                    if (entryList != null && !entryList.isEmpty()) {
                        bucketIterator = entryList.iterator();
                        bucketIndex = i;
                        break;
                    }
                }
            }

            next = bucketIterator.hasNext() ? bucketIterator.next() : null;
            return result;
        }

        @Override
        public void remove() {

        }
    }
}
