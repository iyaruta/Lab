package ua.kpi.pti.lab4;

public class MyStack extends MyLinkedList {

    public void push(String e) {
        add(e);
    }

    public String pop(){
        return removeLast();
    }

}
