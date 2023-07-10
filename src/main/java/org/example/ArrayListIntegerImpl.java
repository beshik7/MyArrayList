package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayListIntegerImpl implements IntegerList {
    private Integer[] items;
    private int size;

    public ArrayListIntegerImpl(int initialCapacity) {
        if (initialCapacity <= 0)
            throw new IllegalArgumentException("Capacity must be greater than 0");
        this.items = new Integer[initialCapacity];
        this.size = 0;
    }
    @Override
    public Integer add(Integer item) {
        if (item == null)
            throw new IllegalArgumentException("Nulls are not allowed");
        if (size == items.length)
            items = Arrays.copyOf(items, size * 2);
        items[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (item == null)
            throw new IllegalArgumentException("Nulls are not allowed");
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (size == items.length)
            items = Arrays.copyOf(items, size * 2);
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (item == null)
            throw new IllegalArgumentException("Nulls are not allowed");
        Integer oldValue = items[index];
        items[index] = item;
        return oldValue;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null)
            throw new IllegalArgumentException("Nulls are not allowed");
        int index = indexOf(item);
        if (index == -1)
            throw new NoSuchElementException("Element not found");
        Integer removedValue = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        size--;
        return removedValue;
    }

    @Override
    public Integer remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index out of bounds");
        Integer removedValue = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        size--;
        return removedValue;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++)
            if (items[i].equals(item))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--)
            if (items[i].equals(item))
                return i;
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index out of bounds");
        return items[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null)
            throw new IllegalArgumentException("Nulls are not allowed");
        if (size != otherList.size())
            return false;
        for (int i = 0; i < size; i++)
            if (!items[i].equals(otherList.get(i)))
                return false;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            items[i] = null;
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(items, size);
    }

    // Новые методы
    private void sort(){
        Arrays.sort(this.items, 0, size);
    }

    private int binarySearch(Integer item) {
        this.sort();
        return Arrays.binarySearch(this.items, 0, size, item);
    }
}