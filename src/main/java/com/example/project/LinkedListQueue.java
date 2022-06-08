package com.example.project;

public class LinkedListQueue<T extends Comparable<T>> implements MyQueue<T> {

    private SinglyLinkedList<T> list;

    LinkedListQueue() {
        list = new SinglyLinkedList<T>();
    }

    public void enqueue(T v) {
        list.addLast(v);
    }

    public T dequeue() {
        T ans = list.getFirst();
        list.removeFirst();
        return ans;
    }

    public T first() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {

        // Creación de cola
        MyQueue<Integer> q = new LinkedListQueue<Integer>();

        // Ejemplo de inserción de elementos en la cola
        for (int i = 1; i <= 8; i++)
            q.enqueue(i); // insertar ‘i’ al final de la cola
        System.out.println(q);

        // Ejemplo de eliminación de elementos de la cola
        for (int i = 0; i < 4; i++) {
            int aux = q.dequeue(); // elimina el elemento al principio de la cola
            System.out.println("q.dequeue() = " + aux);
        }
        System.out.println(q);

        // Ejemplo de uso de otros métodos
        System.out.println("q.size() = " + q.size());
        System.out.println("q.isEmpty() = " + q.isEmpty());
        System.out.println("q.first() = " + q.first());
    }

}
