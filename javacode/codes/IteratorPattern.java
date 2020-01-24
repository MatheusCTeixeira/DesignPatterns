
package javacode.codes;

import java.util.ArrayList;

interface Iterator<T> {
    T getNext();
    boolean hasMore();
}

interface Iterable<T> {
    T getElementAt(int i);
    Iterator<T> getIterator();
    int size();
}


class ConcreteIterator<T> implements Iterator<T> {
    private Iterable<T> iterable;
    private int currentPos = 0;

    public ConcreteIterator(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    public T getNext() {
        return iterable.getElementAt(currentPos++);
    }

    public boolean hasMore() {
        return currentPos < iterable.size();
    }
}

class ConcreteIterable<T> implements Iterable<T> {
    private ArrayList<T> data;
    final int maxSize;

    public ConcreteIterable(int maxSize) {
        this.maxSize = maxSize;
        data = new ArrayList<>();
    }

    public Iterator<T> getIterator() {
        return new ConcreteIterator<T>(this);
    }

    public int size() {
        return this.data.size();
    }

    public void addElement(T v) {
        data.add(v);
    }

    public T getElementAt(int i) {
        return data.get(i);
    }
}


public class IteratorPattern {
    public static void main(String args[]) {
        ConcreteIterable<String> it = new ConcreteIterable<String>(7);
        it.addElement("M");
        it.addElement("A");
        it.addElement("T");
        it.addElement("H");
        it.addElement("E");
        it.addElement("U");
        it.addElement("S");

        System.out.println("Starting...");
        Iterator<?> iterator = it.getIterator();
        while (iterator.hasMore()) {
            System.out.println(iterator.getNext());
        }
    }
}
