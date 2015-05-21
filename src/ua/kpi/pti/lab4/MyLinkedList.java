package ua.kpi.pti.lab4;

import java.util.Iterator;

public class MyLinkedList implements Iterable<String> {
    private Object first;
    private Object last;
    private int size;

    public int size() {
        return size;
    }

    public void add(String text) {
        Object element = new Object();
        element.setValue(text);
        if (first == null) {
            first = element;
            last = first;
        } else {
            element.setPrev(last);
            last.setNext(element);
        }
        last = element;
        size++;
    }

    public void remove(int index) {
        if (first == null || index < 0 || index >= size) {
            return;
        }

        Object current = first;
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        Object next = current.getNext();
        Object prev = current.getPrev();

        if (prev == null) {
            first = next;
        } else {
            prev.setNext(next);
        }

        if (next == null) {
            last = prev;
        } else {
            next.setPrev(prev);
        }
        size--;
    }

    public boolean contains(String arg){
        Object current = first;
        while (current != null){
            if (arg == current.getValue() || (arg != null && arg.equals(current.getValue()))){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int find(String fin){
        Object brush = first;
        int i = 0;
        while (brush != null){
            if (fin == brush.getValue() || (fin != null && fin.equals(brush.getValue()))){
                return i;
            }
            brush = brush.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public Iterator<String> iterator() {
        return new LListIterator(first);
    }

    public MyLinkedList union(MyLinkedList list){
        MyLinkedList unionList = new MyLinkedList();
        for (String val : this) {
            unionList.add(val);
        }
        for(String val : list) {
            unionList.add(val);
        }
        return unionList;
    }

    public MyLinkedList intersect(MyLinkedList list){
        MyLinkedList intersectList = new MyLinkedList();
        for(String var : this){
            for(String val : list) {
                 if(var.equals(val)) {
                     intersectList.add(var);
                 }
            }
        }
        return intersectList;
    }

}
