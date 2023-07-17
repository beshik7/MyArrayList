package com.skypro.myArrayList;

import org.example.ArrayListIntegerImpl;
import org.example.IntegerList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListIntegerTest {
    private IntegerList list;

    @BeforeEach
    public void setup() {
        list = new ArrayListIntegerImpl(10);
    }

    @Test
    public void testAdd() {
        assertEquals(new Integer(5), list.add(5));
        assertEquals(new Integer(3), list.add(3));
        assertEquals(new Integer(1), list.add(1));
        assertEquals(3, list.size());
    }

    @Test
    public void testAddAtIndex() {
        list.add(5);
        list.add(3);
        list.add(1);
        assertEquals(new Integer(7), list.add(1, 7));
        assertEquals(new Integer(7), list.get(1));
    }

    @Test
    public void testSet() {
        list.add(5);
        list.add(2);
        assertEquals(new Integer(2), list.set(1, 2));
        assertEquals(new Integer(2), list.get(1));
    }

    @Test
    public void testRemove() {
        list.add(5);
        list.add(3);
        list.add(1);
        assertEquals(new Integer(3), list.remove(new Integer(3)));
        assertFalse(list.contains(3));
    }

    @Test
    public void testIndexOf() {
        list.add(5);
        list.add(3);
        list.add(1);
        assertEquals(1, list.indexOf(new Integer(3)));
    }

    @Test
    public void binarySearchForExistingItem() {
        ArrayListIntegerImpl list = new ArrayListIntegerImpl(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Assume you have implemented a public method findItem that calls binarySearch
        int index = list.findItem(4);

        assertEquals(3, index);
    }

    @Test
    public void addNewItemWhenArrayIsFull() {
        ArrayListIntegerImpl list = new ArrayListIntegerImpl(2);
        list.add(1);
        list.add(2);
        list.add(3);  //сподвигнет array к росту

        assertEquals(3, list.size());
        assertTrue(list.contains(3));
    }

    @Test
    public void sortArray() {
        ArrayListIntegerImpl list = new ArrayListIntegerImpl(5);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        Integer[] sortedList = list.sortedList();

        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, sortedList);
    }
}
