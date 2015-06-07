package ua.kpi.pti.lab6;

import ua.kpi.pti.lab5.MyArrayList;
import ua.kpi.pti.lab7.MyList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class MyCollections {

    private MyCollections() {

    }

    public static void sort(MyList list) {
        sort(list, new DefaultComparator());
    }

    public static void sort(MyList list, Comparator comparator) {
        if (list instanceof RandomAccess) {
            sortBubble(list, comparator);
        } else {
            quickSort(list, 0, list.size() - 1, comparator);
        }
    }

    private static void sortBubble(MyList list, Comparator comparator) {
        Object elem;
        for (int j = 0; j < list.size(); j++) {
            for (int i = j + 1; i < list.size(); i++) {
                if (comparator.compare(list.get(i), list.get(j)) < 0) {
                    elem = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, elem);
                }
            }
        }
    }

    private static void quickSort(MyList arr, int left, int right, Comparator comparator) {
        int index = partition(arr, left, right, comparator);
        if (left < index - 1)
            quickSort(arr, left, index - 1, comparator);
        if (index < right)
            quickSort(arr, index, right, comparator);
    }

    private static int partition(MyList arr, int left, int right, Comparator comparator) {
        int i = left, j = right;

        Comparable pivot = (Comparable)arr.get((left + right) / 2);

        while (i <= j) {
            while (comparator.compare(arr.get(i), pivot) < 0)
                i++;
            while (comparator.compare(arr.get(j), pivot) > 0)
                j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    public static void swap(MyList list, int i, int j) {
        Object iElement = list.get(i);
        list.set(i, list.get(j));
        list.set(j, iElement);
    }

    public static void copy(MyList dest, MyList src) {
        int i = 0;
        for (Object o : src) {
            dest.set(i, o);
            i++;
        }
    }

    public static void reverse(MyList list) {
        Object elem;
        for (int i = 0, j = list.size() - 1; i < list.size() / 2; i++, j--) {
            elem = list.get(i);
            list.set(i, list.get(j));
            list.set(j, elem);
        }
    }

    public static int binarySearch(MyArrayList list, Integer key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Comparable value = (Comparable) list.get(mid);
            int position = value.compareTo(key);

            if (position < 0)
                low = mid + 1;
            else if (position > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    private static class DefaultComparator implements Comparator<Comparable> {
        @Override
        public int compare(Comparable o1, Comparable o2) {
            return o1.compareTo(o2);
        }
    }

}
