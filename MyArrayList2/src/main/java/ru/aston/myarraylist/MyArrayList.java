package ru.aston.myarraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<E> implements MyList<E>{

    private final int DEFAULT_ARRAY_SIZE = 16;

    private int elementsInArray;

    private Object[] arrayList;

    public MyArrayList() {
        this.arrayList = (E[]) new Object[DEFAULT_ARRAY_SIZE];
        this.elementsInArray = 0;
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Size must be more than 0. Try agan.");
        }

        this.arrayList = new Object[capacity];
        this.elementsInArray = 0;
    }

    public void add (E element) {

        if (isArrayFull()) {
            copyArray();
        }

        this.arrayList[this.elementsInArray] = element;
        this.elementsInArray++;

    }

    @Override
    public void add(int index, E element) {

        if (isArrayFull()) {
            copyArray();
        }

        if (index > this.arrayList.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        arrayList[index] = element;
        this.elementsInArray++;
    }


    @Override
    public void addAll(Collection<? extends E> collection) {

        Object[] temp = collection.toArray();

        for (int i = 0; i < temp.length; i++) {
            if (isArrayFull()) {
                copyArray();
            } else {
                this.arrayList[this.elementsInArray] = temp[i];
                this.elementsInArray++;
            }
        }
    }

    @Override
    public void clear() {

        for (int i = 0; i < this.arrayList.length; i++) {

            this.arrayList = new Object[DEFAULT_ARRAY_SIZE];
            elementsInArray = 0;
        }
    }

    @Override
    public E get(int index) {

        E element = null;

        try {
            element = (E) this.arrayList[index];
        } catch (IndexOutOfBoundsException e) {
           e.printStackTrace();
        }

        return element;
    }

    @Override
    public boolean isEmpty() {
        return this.elementsInArray == 0;
    }

    @Override
    public void remove(int index) {

        this.arrayList[index] = null;
        this.elementsInArray--;
    }

    @Override
    public void remove(Object element) {

        for(int i = 0; i < this.elementsInArray; i++) {
            if (element.equals(this.arrayList[i])) {
                this.arrayList[i] = null;
                this.elementsInArray--;
                return;
            }
        }
    }

    @Override
    public <E> void sort(Comparator<? super E> comparator) {

        mergeSort((E[])this.arrayList, 0, arrayList.length - 1, comparator);;
    }

    private static <E> void mergeSort(E[] a, int from, int to, Comparator<? super E> comp) {
        if (from == to)
            return;
        int mid = (from + to) / 2;
        mergeSort(a, from, mid, comp);
        mergeSort(a, mid + 1, to, comp);
        merge(a, from, mid, to, comp);
    }
    private static <E> void merge(E[] a, int from, int mid, int to, Comparator<? super E> comp) {
        int n = to - from + 1;
        Object[] values = new Object[n];
        int fromValue = from;
        int middleValue = mid + 1;
        int index = 0;
        while (fromValue <= mid && middleValue <= to) {
            if (comp.compare(a[fromValue], a[middleValue]) < 0) {
                values[index] = a[fromValue];
                fromValue++;
            } else {
                values[index] = a[middleValue];
                middleValue++;
            }
            index++;
        }
        while (fromValue <= mid) {
            values[index] = a[fromValue];
            fromValue++;
            index++;
        }
        while (middleValue <= to) {
            values[index] = a[middleValue];
            middleValue++;
            index++;
        }
        for (index = 0; index < n; index++)
            a[from + index] = (E) values[index];
    }

    private boolean isArrayFull() {
        return this.arrayList.length == this.elementsInArray;
    }

    private void copyArray() {

        Object[] tempArray = new Object[increaseArraySize()];

        int tempElement = 0;

        for (int i = 0; i < this.arrayList.length; i++, tempElement++) {

            if (this.arrayList[i] == null) {
                tempElement--;
                continue;
            }

            tempArray[tempElement] = this.arrayList[i];
        }

        this.arrayList = tempArray;

    }

    private int increaseArraySize() {
        return this.arrayList.length * 2;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arrayList=" + Arrays.toString(arrayList) +
                '}';
    }
}
