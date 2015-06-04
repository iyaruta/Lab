package ua.kpi.pti.lab4;

import ua.kpi.pti.lab7.Queue;

public class MyQueue extends MyLinkedList implements Queue<String> {

    public void offer(String e) {
        add(e);
    }

    public String peek() {
        return getFirst();
    }

    public String poll() {
        return removeFirst();
    }

}
