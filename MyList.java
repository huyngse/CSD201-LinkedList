/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistproject;

/**
 *
 * @author huyngo
 */
public class MyList<E> {

    Node<E> head, tail;
    int size = 0;

    public MyList() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(E e) {
        head = new Node(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node node = new Node(e, null);
        if (isEmpty()) {
            head = tail = node;
            size++;
            return;
        }
        //tail == null
        tail.next = node;
        tail = node;
        size++;
    }

    public void addAfter(Node current, E e) {
        if (isEmpty()) {
            return;
        }
        if (current != null) {
            Node newNode = new Node(e, current.next);
            current.next = newNode;
            if (newNode.next == null) {
                tail = newNode;
            }
            size++;
        } else {
            addFirst(e);
        }
    }

    public void display() {
        if (isEmpty()) {
            return;
        }
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.e + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E value = tail.e;
        if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        return value;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = head.e;
        if (head == tail) {
            head = tail = null;
        } else {
            if (head.next == null) {
                tail = head;
            }
            head = head.next;
        }
        size--;
        return value;
    }

    public E remove(E e) {
        if (isEmpty()) {
            return null;
        }
        Node<E> current = head;
        if (current.e.equals(e)) {
            return removeFirst();
        }
        while (!current.next.e.equals(e) && current.next != null) {
            current = current.next;
        }
        if (current.next != null) {
            if (current.next == tail) {
                tail = current;
            }
            E value = current.next.e;
            current.next = current.next.next;
            return value;
        }
        return null;
    }

    public Node getNode(E e) {
        if (isEmpty()) {
            return null;
        }
        Node current = head;
        while (current != null) {
            if (current.e.equals(e)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public E removeAfter(Node<E> node) {
        if (isEmpty() || node == tail) {
            return null;
        }
        if (node == null) {
            return removeFirst();
        }
        if (node.next == tail) {
            return removeLast();
        }
        size--;
        E value = node.next.e; 
        node.next = node.next.next;
        return value;
    }
}
