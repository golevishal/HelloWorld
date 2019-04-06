package com.experiments;

import java.util.Stack;

public class MinStack {
    int min;
    Stack<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void print() {
        System.out.println("Stack is " + stack);
    }

    public void push(int x) {
        System.out.println("Pushing " + x);
        if (stack.isEmpty()) {
            min = x;
            stack.push(0);
        } else {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }

    public int pop() {
        int top = stack.pop();
        int element = 0;
        if (top > 0) {
            element = min + top;
        } else {
            element = min;
            min = min - top;
        }
        System.out.println("Popping " + element);
        return element;
    }

    public int peek() {
        int top = stack.peek();
        if (top > 0) {
            System.out.println("Peeking " + (min + top));
            return min + top;
        } else {
            System.out.println("Peeking " + min);
            return min;
        }
    }

    public int min() {
        System.out.println("Returning min " + min);
        return min;
    }

    public static void main(String[] args)
    {
        MinStack s = new MinStack();
        s.push(3);
        s.print();
        s.push(5);
        s.print();
        s.min();
        s.print();
        s.push(2);
        s.print();
        s.push(1);
        s.print();
        s.min();
        s.print();
        s.pop();
        s.print();
        s.min();
        s.print();
        s.pop();
        s.print();
        s.peek();
        s.print();
    }
}
