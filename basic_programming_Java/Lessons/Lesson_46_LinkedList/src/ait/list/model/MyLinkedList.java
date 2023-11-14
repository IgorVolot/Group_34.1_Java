package ait.list.model;

import ait.list.interfaces.IList;

import java.util.Iterator;

public class MyLinkedList<E> implements IList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(1)
    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(last, element, null);
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    // O(n)
    @Override
    public void clear() {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            unLink(node);
        }
        size = 0;
    }

    // O(n)
    @Override
    public boolean add(int index, E element) { // TODO
        if (index == size) {
            return add(element);
        }
        if (index == 0){
            Node<E> next = first;
            Node<E> newNode = new Node<>(null, element, next.prev);
            first = newNode;
            newNode.data = element;
            size++;
            return true;
        } else {
            Node<E> prev = getNodeByIndex(index - 1);
            Node<E> newNode = new Node<>(prev, element, prev.next);
            Node<E> next = newNode;

        newNode.prev = prev.next;
        newNode.next = next.prev;
            newNode.data = element;
//            prev.next.next = null;
//            next.prev.prev = null;
            size++;
            return true;
        }
    }

    // O(n)
    @Override
    public E get(int index) {
        Node<E> node = getNodeByIndex(index);
        return node.data;
    }

    // O(n)
    private Node<E> getNodeByIndex(int index) {
        checkIndex(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // O(1)
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    // O(n)
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o != null) {
            for (Node<E> node = first; node != null; node = node.next, index++) {
                if (o.equals(node.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next, index++) {
                if (o == node.data) {
                    return index;
                }
            }
        }
        return -1;
    }

    // O(n)
    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o != null) {
            for (Node<E> node = last; node != null; node = node.prev, index--) {
                if (o.equals(node.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = last; node != null; node = node.prev, index--) {
                if (o == node.data) {
                    return index;
                }
            }
        }
        return -1;
    }

    // O(1)
    @Override
    public E remove(int index) {
        Node<E> node = getNodeByIndex(index);
        return unLink(node);
    }

    private E unLink(Node<E> node) {
        E victim = node.data;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev != null) {
            prev.next = next;
            node.prev = null;
        } else {
            first = next;
        }
        if (next != null) {
            next.prev = prev;
            node.next = null;
        } else {
            last = prev;
        }
        node.data = null;
        size--;
        return victim;
    }

    // O(n)
    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeByIndex(index);
        E victim = node.data;
        node.data = element;
        return victim;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = first;
            int index = 0;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E element = node.data;
                node = node.next;
                index++;
                return element;
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
