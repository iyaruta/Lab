package ua.kpi.pti.lab4;

import java.util.Iterator;

public class MyLinkedList implements Iterable<String> {

    private MyElement first;
    private MyElement last;
    private int size;

    public int size() {
        return size;
    }

    public void add(String text) {
        MyElement element = new MyElement();
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

    public void addFirst(String e) {
        MyElement element = new MyElement();
        element.setValue(e);
        if (first != null) {
            first.setPrev(element);
            element.setNext(first);
        }
        first = element;
        size++;
    }

    public void addLast(String e)  {
        MyElement element = new MyElement();
        element.setValue(e);
        if (last != null) {
            last.setNext(element);
            element.setPrev(first);
        }
        last = element;
        size++;
    }

    public String getFirst() {
        return first == null ? null : first.getValue();
    }

    public String getLast() {
        return last == null ? null : last.getValue();
    }

    public String removeFirst() {
        String res = null;
        if (first != null) {
            res = first.getValue();
            MyElement next = first.getNext();
            first = next;
            if (next != null) {
                next.setPrev(null);
            }
            size--;
        }

        if (size == 0) {
            first = null;
            last = null;
        }

        return res;
    }

    public String removeLast() {
        String res = null;
        if (last != null) {
            res = last.getValue();
            MyElement next = last.getPrev();
            last = next;
            if (next != null) {
                next.setNext(null);
            }
            size--;
        }

        if (size == 0) {
            first = null;
            last = null;
        }

        return res;
    }

    public void remove(int index) {
        if (first == null || index < 0 || index >= size) {
            return;
        }

        MyElement current = first;
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        MyElement next = current.getNext();
        MyElement prev = current.getPrev();

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
        MyElement current = first;
        while (current != null){
            if (arg == current.getValue() || (arg != null && arg.equals(current.getValue()))){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int find(String fin){
        MyElement brush = first;
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
