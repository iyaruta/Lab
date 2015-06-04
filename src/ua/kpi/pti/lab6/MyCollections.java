package ua.kpi.pti.lab6;

import ua.kpi.pti.lab5.MyArrayList;
import ua.kpi.pti.lab7.MyList;

public class MyCollections {

    private MyCollections() {

    }

    public static void sort(MyList myArrayList) {
        Object elem;
        for (int j = 0; j < myArrayList.size(); j++) {
            for (int i = j + 1; i < myArrayList.size(); i++) {
                Comparable comp = (Comparable) myArrayList.get(i);
                if (comp.compareTo(myArrayList.get(j)) < 0) {
                    elem = myArrayList.get(j);
                    myArrayList.set(j, myArrayList.get(i));
                    myArrayList.set(i, elem);
                }
            }
        }
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

}
