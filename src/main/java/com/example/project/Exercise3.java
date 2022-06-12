package com.example.project;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Set;

public class Exercise3 {
    public static void main(final String[] args) throws IOException {
        final Exercise3 obj = new Exercise3();
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            final String s = br.readLine();
            System.out.println(obj.transformInfixToPostfix(s));
        }
    }

    public static String reverse(String s) {
        String r = "";
        for(int i = 0; i < s.length(); i++)
            r = s.substring(i, i + 1) + r;
        return r;
    }

    public String transformInfixToPostfix(String infix) {
        final MyStack<Character> operatorsStack = new LinkedListStack<>();
        String postfix = "";
        
        final HashMap<Character, Integer> precedences = new HashMap<>();
        precedences.put('(', -1); // Special Case
        precedences.put(')', -1); // Special Case
        precedences.put('-', 0);
        precedences.put('+', 1);
        precedences.put('/', 2);
        precedences.put('*', 3);
        precedences.put('^', 4);
        final Set<Character> operators = precedences.keySet();

        for(char current: infix.toCharArray()) {
            if(current == '(') {
                operatorsStack.push('(');
            } else if(current == ')') {
                while(!operatorsStack.isEmpty() && operatorsStack.top() != '(')
                    postfix += operatorsStack.pop();
                
                operatorsStack.pop(); // (
            } else if(!operators.contains(current)) {
                postfix += current;
            } else if(operators.contains(current) && operatorsStack.isEmpty()) {
                operatorsStack.push(current);
            } else if(!operatorsStack.isEmpty()) {
                if(precedences.get(current) > precedences.get(operatorsStack.top())) {
                    operatorsStack.push(current);
                } else if(precedences.get(current) <= precedences.get(operatorsStack.top())) {
                    while(!operatorsStack.isEmpty() && precedences.get(current) <= precedences.get(operatorsStack.top())) {
                        postfix += operatorsStack.pop();
                    }

                    operatorsStack.push(current);
                }
            }
        }

        while(!operatorsStack.isEmpty())
            postfix += operatorsStack.pop();

        return postfix;
    }
}
