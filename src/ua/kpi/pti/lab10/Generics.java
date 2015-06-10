package ua.kpi.pti.lab10;

import java.util.*;

public class Generics {

    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        c.addAll(Arrays.asList(a));
    }

    public static <T> void copyAll(Collection<? extends T> collection, Collection<T> out) {
        out.addAll(collection);
    }

    public static <T> Collection<T> copy(Collection<T> collection, T copy) {
        ArrayList<T> list = new ArrayList<>();
        for (T element : collection) {
            if (((Comparable) element).compareTo(copy) > 0) {
                list.add(element);
            }
        }
        return list;
    }
}
