package ru.aston.myarraylist;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public interface MyList<E> {

    void add(E element);

    void add(int index, E element);

    void addAll(Collection<? extends E> collection);

    void clear();

    E get(int index);

    boolean isEmpty();

    void remove(int index);

    void remove(Object o);

   <E> void sort(Comparator<? super E> comparator);
}
