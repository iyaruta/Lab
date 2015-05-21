package ua.kpi.pti.lab4;

public class Object {

    private String value;
    private Object next;
    private Object prev;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getNext() {
        return next;
    }

    public void setPrev(Object prev) {
        this.prev = prev;
    }

    public Object getPrev() {
        return prev;
    }

}
