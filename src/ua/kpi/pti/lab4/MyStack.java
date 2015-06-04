package ua.kpi.pti.lab4;

import ua.kpi.pti.lab7.Stack;

public class MyStack extends MyLinkedList implements Stack<String> {

    public void push(String e) {
        add(e);
    }

    public String pop(){
        return removeLast();
    }

}
