package org.example;

import java.util.Arrays;
public class ArrayListString implements StringList {
    private String[] elements;
    private int size = 0;

    public ArrayListString(int initialCapacity) {
        this.elements = new String[initialCapacity];
    }

    @Override
    public String add(String item) {
        if (item == null) throw new StringListException("Null values are not allowed");
        ensureCapacity();
        elements[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null || index > size || index < 0) throw new StringListException("Invalid index or null item");
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
        return item;
    }
    @Override
    public String set(int index, String item) {
        if (item == null || index >= size || index < 0) throw new StringListException("Invalid index or null item");
        String oldItem = elements[index];
        elements[index] = item;
        return oldItem;
    }
    @Override
    public String remove(String item) {
        if (item == null) throw new StringListException("Null values are not allowed");
        for (int i = 0; i < size; i++) {
            if (item.equals(elements[i])) {
                return remove(i);
            }
        }
        throw new StringListException("Item not found");
    }
    @Override
    public String remove(int index) {
        if (index >= size || index < 0) throw new StringListException("Invalid index");
        String removedItem = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return removedItem;
    }
    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) throw new StringListException("Null values are not allowed");
        for (int i = 0; i < size; i++) {
            if (item.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(String item) {
        if (item == null) throw new StringListException("Null values are not allowed");
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= size || index < 0) throw new StringListException("Invalid index");
        return elements[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) throw new StringListException("Null values are not allowed");
        if (this.size() != otherList.size()) return false;
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newSize = size * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

}

