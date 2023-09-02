package org.example;

public class Main {
    public static void main(String[] args) {
        StringList myList = new ArrayListString(10);
        myList.add("Hello");
        myList.add("World");
        myList.add(1, "Java");
        myList.add("Programming");

        System.out.println("Size of the list: " + myList.size());
        System.out.println("Contents of the list: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        System.out.println("Does the list contain 'World'? " + myList.contains("World"));
        System.out.println("Does the list contain 'Python'? " + myList.contains("Python"));

        myList.remove("World");
        myList.remove(2);

        System.out.println("Size of the list after removing elements: " + myList.size());
        System.out.println("Contents of the list after removing elements: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}