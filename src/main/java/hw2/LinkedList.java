package hw2;

import java.util.Iterator;

public class LinkedList<T> {

    private List<Node> head;

    class Node {
        private T value;
        private Node prev;
        private Node next;

        private Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    void add(T element) {
        Node node = new Node(element);
        if (head == null) {
            head = new ArrayList<>();
            head.add(node);
        } else {
            Node prev = head.get(head.size() - 1);
            node.prev = prev;
            prev.next = node;
            head.add(node);
        }
    }

    void removeLast() {
        if (head != null) {
            Node key = head.get(head.size() - 1);
            Node temp = head.get(0);
            Node prev = null;

            while (temp != null && temp != key) {
                prev = temp;
                temp = temp.next;
            }

            if (temp == null)
                return;

            prev.next = temp.next;
            head.remove(key);
        }
    }

    T get(int index) {
        Node element = head.get(index);
        return element.value;
    }

    int indexOf(T element) {
        int index = 0;
        for (Node node : head) {
            if (node.value.equals(element)) return index;
            index++;
        }
        return -1;
    }

    void print() {
        Iterator<Node> iterator = head.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().value);
        }
    }


}