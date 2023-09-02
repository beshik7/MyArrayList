package com.skypro.myArrayList;

import org.example.ArrayListString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListStringTest {
    private ArrayListString list;
    @BeforeEach
    void setUp() {
        list = new ArrayListString(10);
    }

    @Test
    void testAdd() {
        String item = "Hello";
        list.add(item);
        assertEquals(1, list.size());
        assertEquals(item, list.get(0));
    }
    @Test
    void testAddAtSpecificIndex() {
        list.add("Hello");
        String item = "World";
        list.add(1, item);
        assertEquals(2, list.size());
        assertEquals(item, list.get(1));
    }

    @Test
    void testRemove() {
        String item = "Hello";
        list.add(item);
        String removedItem = list.remove(item);
        assertEquals(0, list.size());
        assertEquals(item, removedItem);
    }

    @Test
    void testRemoveAtIndex() {
        String item = "Hello";
        list.add(item);
        String removedItem = list.remove(0);
        assertEquals(0, list.size());
        assertEquals(item, removedItem);
    }

    @Test
    void testIndexOf() {
        String item = "Hello";
        list.add(item);
        int index = list.indexOf(item);
        assertEquals(0, index);
    }
}
