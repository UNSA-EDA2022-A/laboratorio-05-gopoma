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
        MyStack<Character> stack = new LinkedListStack<>();

        // Colocar codigo aqui
        for(char current: str.toCharArray()) {
            if(current != ')') {
                stack.push(current);
            } else {
                int contentCounter = 0;
                while(stack.top() != '(') {
                    stack.pop();
                    contentCounter++;
                }
                stack.pop();

                if(contentCounter == 0) {
                    return true;
                }
            }
        }

        return false;
    }
    /*
    public boolean existenDuplicados(String str) {
        MyStack<Character> groupings = new LinkedListStack<>();
        MyStack<Character> contents = new LinkedListStack<>();
        
        // Colocar codigo aqui
        if(str.length() == 0)
            return false;

        final boolean withoutInitializerAtStart = str.charAt(0) != '(';
        final boolean withoutEnderAtEnd = str.charAt(str.length() - 1) != ')';
        final boolean verifyMiddleLeft = str.charAt(0) == '(' && 
        (str.substring(1, str.length()).indexOf(")") < str.substring(1, str.length()).indexOf("("));
        final boolean verifyMiddleRight = str.charAt(str.length() - 1) == ')' &&
        (str.substring(0, str.length() - 1).lastIndexOf("(") > str.substring(0, str.length() - 1).lastIndexOf(")"));

        final boolean needsNormalization = withoutInitializerAtStart ||
        withoutEnderAtEnd ||
        verifyMiddleLeft ||
        verifyMiddleRight;

        if(needsNormalization)
            groupings.push('(');

        for(int i = 0; i < str.length(); i++) {
            final char current = str.charAt(i);

            if(current != '(' && current != ')') {
                contents.push('*');
                if(str.substring(i + 1, str.length()).indexOf("(") == -1 && str.substring(i + 1, str.length()).indexOf(")") == -1) {break;}
                for(int j = i + 1; j < str.length(); j++) {
                    if(str.charAt(j) == '(' || str.charAt(j) == ')') {
                        i = j - 1;
                        break;
                    }
                }
            } else if(current == '(') {
                groupings.push('(');
            }
        }

        return contents.size() < groupings.size();
    }
    */
}
