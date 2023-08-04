package ru.aston.myarraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<E> implements MyList<E> {

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

    public void add(E element) {

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

        for (int i = index; i < this.elementsInArray; i++) {
            this.arrayList[i] = arrayList[i + 1];
            this.arrayList[elementsInArray] = null;
            this.elementsInArray--;
        }
    }

    @Override
    public void remove(Object element) {

        for (int i = 0; i < this.elementsInArray; i++) {
            if (element.equals(this.arrayList[i])) {
                remove(i);
            }
        }
    }

    @Override
    public <E> void sort(Comparator<? super E> comparator) {

        trimToSize();
        mergeSort((E[]) this.arrayList, 0, arrayList.length - 1, comparator);
    }

    private <E> void mergeSort(E[] array, int low, int high, Comparator<? super E> comparator) {
        if (high <= low) return;

        int mid = (low + high) / 2;
        mergeSort(array, low, mid, comparator);
        mergeSort(array, mid + 1, high, comparator);
        merge(array, low, mid, high, comparator);
    }

    private <E> void merge(E[] array, int low, int mid, int high, Comparator<? super E> comparator) {

        Object[] leftArray = new Object[mid - low + 1];
        Object[] rightArray = new Object[high - mid];

        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (comparator.compare((E) leftArray[leftIndex], (E) rightArray[rightIndex]) < 0) {
                    array[i] = (E) leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = (E) rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                array[i] = (E) leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                array[i] = (E) rightArray[rightIndex];
                rightIndex++;
            }
        }
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

    public void trimToSize() {
        Object[] temp = new Object[elementsInArray];
        System.arraycopy(arrayList, 0, temp, 0, temp.length);
        this.arrayList = temp;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arrayList=" + Arrays.toString(arrayList) +
                '}';
    }
}
