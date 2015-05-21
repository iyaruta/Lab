package ua.kpi.pti.lab6;

import ua.kpi.pti.lab4.MyLinkedList;
import ua.kpi.pti.lab5.MyArrayList;

import java.util.List;

public class MyCollections {

    private MyCollections() {

    }

    public static void sort(MyLinkedList list) {
        list.iterator();

    }

    public static void swap(MyLinkedList list, int i, int j) {

    }

    public static void copy(MyLinkedList dest, MyLinkedList src) {
//        src.clear();
//        for (String el : dest) {
//            src.add(el);
//        }
    }

    public static void reverse(MyLinkedList list) {

    }


    public static void sort(MyArrayList myArrayList) {

    }

    public static void swap(MyArrayList list, int i, int j) {
        Object iElement = list.get(i);
        list.set(i, list.get(j));
        list.set(j, iElement);
    }

    public static void copy(MyArrayList dest, MyArrayList src) {
//        src.clear();
//        for (String el : dest) {
//            src.add(el);
//        }
    }

    public static void reverse(MyArrayList list) {

    }

}
