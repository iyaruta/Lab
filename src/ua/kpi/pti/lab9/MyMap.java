package ua.kpi.pti.lab9;

import java.util.Iterator;

public interface MyMap {

    void clear();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    Object get(Object key);

    boolean isEmpty();

    Object put(Object key, Object value);

    Object remove(Object key);

    int size();

    Iterator entryIterator();

    interface Entry {
        Object getKey();
        Object getValue();
        Object setValue(Object value);
        boolean equals(Object o);
        int hashCode();
    }

}
