package com.example.project;

import java.util.Scanner;
import java.util.HashMap;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public static <T extends Comparable<T>> boolean includes(T[] arr, T expected) {
        for(T c: arr) {
            if(c.compareTo(expected) == 0)
                return true;
        }
        return false;
    }

    public boolean esBalanceado(String s) {
        final MyStack<Character> stack = new LinkedListStack<>();
        final HashMap<Character, Character> inv = new HashMap<Character, Character>();
        inv.put('(', ')');
        inv.put(')', '(');
        inv.put('[', ']');
        inv.put(']', '[');
        inv.put('{', '}');
        inv.put('}', '{');
        Character[] initializers = {'(', '[', '{'};

        for(char c: s.toCharArray()) {
            if(stack.isEmpty() || includes(initializers, c) || inv.get(stack.top()) != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
