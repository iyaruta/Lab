package ua.kpi.pti.lab4;

import ua.kpi.pti.lab7.MyList;

import java.util.Iterator;
import java.util.Queue;

public class MyLinkedList implements Iterable<String>, MyList<String> {

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

    public void add(int index, String e) {
        if (index == size) {
            addLast(e);
        } else if (index == 0) {
            addFirst(e);
        } else {
            MyElement existed = getByIndex(index);
            MyElement prev = existed.getPrev();
            MyElement newElement = new MyElement();
            newElement.setValue(e);
            prev.setNext(newElement);
            newElement.setPrev(prev);
            newElement.setNext(existed);
            existed.setPrev(newElement);
            size++;
        }
    }

    public void addFirst(String e) {
        MyElement element = new MyElement();
        element.setValue(e);
        if (first != null) {
            first.setPrev(element);
            element.setNext(first);
        } else {
            last = element;
        }
        first = element;
        size++;
    }

    public void addLast(String e)  {
        add(e);
    }

    @Override
    public void addAll(String[] values) {
        for (String s : values) {
            add(s);
        }
    }

    @Override
    public void addAll(int index, String[] values) {
        for (String s : values) {
            add(index, s);
            index++;
        }
    }

    public String get(int index) {
        MyElement current = getByIndex(index);
        return current == null ? null : current.getValue();
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

    public String remove(int index) {
        MyElement current = getByIndex(index);
        if (current == null) {
            return null;
        }
        String value = current.getValue();
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
        return value;
    }

    public void set(int index, String e) {
        MyElement element = getByIndex(index);
        if (element != null) {
            element.setValue(e);
        }
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

    public int indexOf(String value){
        MyElement current = first;
        int i = 0;
        while (current != null){
            if (value == current.getValue() || (value != null && value.equals(current.getValue()))){
                return i;
            }
            current = current.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public Iterator<String> iterator() {
        return new LListIterator(first);
    }



    private MyElement getByIndex(int index) {
        if (first == null || index < 0 || index >= size) {
            return null;
        }

        MyElement current = first;
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        return current;
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

    public String[] toArray() {
        String[] array = new String[size];
        Iterator<String> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            array[i] = next;
            i++;
        }

        return array;
    }
}
