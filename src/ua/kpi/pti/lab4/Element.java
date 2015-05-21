package ua.kpi.pti.lab4;

public class Element {

    private String value;
    private Element next;
    private Element prev;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Element getNext() {
        return next;
    }

    public void setPrev(Element prev) {
        this.prev = prev;
    }

    public Element getPrev() {
        return prev;
    }

}
