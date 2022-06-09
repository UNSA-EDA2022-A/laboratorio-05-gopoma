package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> groupings = new LinkedListStack<>();
        MyStack<Character> contents = new LinkedListStack<>();
        // Colocar codigo aqui
        if(str.length() == 0)
            return true;

        final boolean needsNormalization = str.charAt(0) != '(' || 
        str.charAt(str.length() - 1) != ')' || 
        (str.charAt(0) == '(' && str.substring(1, str.length()).indexOf(')') < str.substring(1, str.length()).indexOf('(')) ||
        (str.charAt(str.length() - 1) == ')' && str.substring(0, str.length() - 1).lastIndexOf('(') > str.substring(0, str.length() - 1).lastIndexOf(')'));
        
        if(needsNormalization)
            groupings.push('(');
        for(int i = 0; i < str.length(); i++) {
            final char current = str.charAt(i);

            if(current == '(') {
                groupings.push('(');
            }
            else if(!contents.isEmpty() && current == ')') {
                contents.pop();
                groupings.pop();
            } else if(current != '(' && current != ')') {
                contents.push('*');
                i = (str.charAt(i + 1) != '(' && str.charAt(i + 2) != '(')? i + str.substring(i + 1, str.length()).indexOf(')') : i;
            } else {
                return true;
            }
        }

        if(needsNormalization && !contents.isEmpty()) {
            contents.pop();
            groupings.pop();
        }

        return !groupings.isEmpty();
    }
}
