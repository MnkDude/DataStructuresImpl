package com.ds.impl.array;

public class Array implements ArrayAbstract {
    private int length = 0;
    private Object[] array;
    public final int size;
    private String type = "";

    public Array(int size) {
        array = new Object[size];
        this.size = size;
    }

    public void add(Object element) {
        if (length >= size) throw new ArrayIndexOutOfBoundsException(length);
        if (type.equals("") && element != null) {
            type = element.getClass().toString();
        }
        if (length == 0) {
            array[length++] = element;
            if (element != null) {
                type = element.getClass().toString();
            }
        } else if (element == null || type.equals(element.getClass().toString())) {
            array[length++] = element;
        } else {
            throw new IllegalArgumentException("Expected " + array[length - 1].getClass() + ", but found " + element.getClass());
        }
    }

    public void add(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (type.equals("")) {
            if (element != null) {
                type = element.getClass().toString();
            }
            array[index] = element;
        } else if (element != null && !type.equals(element.getClass().toString())) {
            throw new IllegalArgumentException("Expected " + array[0].getClass() + ", but found " + element.getClass());
        } else {
            array[index] = element;
        }
    }

    public Object get(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException(index);
        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.length; i++) {
            str.append(array[i].toString()).append(", ");
        }
        if (!str.toString().equals(""))
            str.replace(str.lastIndexOf(","), str.lastIndexOf(" "), "");
        return "[" + str + "]";
    }
}
