package ua.kpi.pti.lab4;

import java.util.Iterator;

public class LListIterator implements Iterator<String> {
    private Object current;


    public LListIterator (Object first){
        current = new Object();
        current.setNext(first);
    }

    @Override
    public boolean hasNext(){
        return current.getNext() != null;
    }

    @Override
    public String next(){
        current = current.getNext();
        return current.getValue();

    }

    @Override
    public void remove(){

    }

}
