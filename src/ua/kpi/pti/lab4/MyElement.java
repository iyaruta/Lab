package ua.kpi.pti.lab4;

public class MyElement {

    private String value;
    private MyElement next;
    private MyElement prev;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setNext(MyElement next) {
        this.next = next;
    }

    public MyElement getNext() {
        return next;
    }

    public void setPrev(MyElement prev) {
        this.prev = prev;
    }

    public MyElement getPrev() {
        return prev;
    }

}
