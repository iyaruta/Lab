package ua.kpi.pti.lab4;

class MyElement {

    private String value;
    private MyElement next;
    private MyElement prev;

    void setValue(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    void setNext(MyElement next) {
        this.next = next;
    }

    MyElement getNext() {
        return next;
    }

    void setPrev(MyElement prev) {
        this.prev = prev;
    }

    MyElement getPrev() {
        return prev;
    }

}
