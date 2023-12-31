package ru.nsu.ccfit.violin.stack;

import ru.nsu.ccfit.violin.calcException.ReferenceToEmptyStack;

import java.sql.SQLOutput;
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack<T> {
    private final Stack<T> data = new Stack<>();

    public void push(T value){
        data.push(value);
    }

    public T pop() throws ReferenceToEmptyStack {
        T value;
        try {
            value = data.pop();
        } catch (EmptyStackException e) {
            throw new ReferenceToEmptyStack();
        }
        return value;
    }

    public void print() throws ReferenceToEmptyStack {
        try{
            System.out.println(data.peek());
        } catch(EmptyStackException e) {
            throw new ReferenceToEmptyStack();
        }
    }

}
