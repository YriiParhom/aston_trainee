package ru.aston.myarraylist;

public class Main {
    public static void main(String[] args) {

        MyList<String> myList = new MyArrayList<>();

        myList.add("Igor");
        myList.add("Sergey");
        myList.add("Yurii");
        myList.add("Svetlana");
        myList.add("Yulia");

        myList.sort(CharSequence::compare);

        System.out.println(myList.toString());

    }
}
