package com.example.project;

public class LinkedListStack<T extends Comparable<T>> implements MyStack<T> {

    private SinglyLinkedList<T> list;

    LinkedListStack() {
        list = new SinglyLinkedList<T>();
    }

    public void push(T v) {
        list.addFirst(v);
    }

    public T pop() {
        T ans = list.getFirst();
        list.removeFirst();
        return ans;
    }

    public T top() {
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

        // creación de pila
        MyStack<Integer> s = new LinkedListStack<Integer>();

        // Ejemplo de inserción de elementos en la pila
        for (int i = 1; i <= 8; i++)
            s.push(i); // inserta ‘i’ en la parte superior de la pila
        System.out.println(s);

        // Ejemplo de eliminación de elementos de la pila
        for (int i = 0; i < 4; i++) {
            int aux = s.pop(); // elimina el elemento en la parte superior de la pila
            System.out.println("s.pop() = " + aux);
        }
        System.out.println(s);

        // Ejemplo de uso de otros métodos
        System.out.println("s.size() = " + s.size());
        System.out.println("s.isEmpty() = " + s.isEmpty());
        System.out.println("s.top() = " + s.top());
    }

}
