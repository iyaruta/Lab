package ua.kpi.pti.lab7;

public interface Queue<T> {

    void offer(T e);
    T peek();
    T poll();

}
