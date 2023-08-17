package org.example;

import java.util.Stack;

public class AlgorithmStack {

    public AlgorithmStack() {
        this(false);
    }

    public AlgorithmStack(boolean advanced) {
        this.advanced = advanced;

    }
    private Stack<Character> stack = new Stack();

    private String trailing = "";

    private boolean advanced = false;

    public void setTrailing(String trailing) {
        this.trailing = trailing;
    }

    private boolean findIdenticalCharacter(Character top, Character middle, Character last) {
        return top == middle && middle == last;
    }

    public String getStackAsString() {
        StringBuilder sb = new StringBuilder();
        for (Character element : stack) {
            sb.append(element);
        }
        return sb.toString();
    }

    private void display(Character item) {
        String advancedInfo = "";
        if(advanced && item > 'a') {
            Character before = (char) (item - 1);
            advancedInfo = String.format(", %s%s%s is replaced by %s", item,item,item, before);
            stack.push(before);
        }

        System.out.println(String.format("-> %s%s%s", getStackAsString(), trailing, advancedInfo));
    }

    public void pushStack(Character item) {
        int size = stack.size();
        if (size <= 1) {
            stack.push(item);
            return;
        } else if (size == 2) {
            Character top = stack.pop();
            Character middle = stack.pop();
            boolean result = findIdenticalCharacter(middle, top, item);
            if (result) {
                display(item);
            }
            else {
                stack.push(middle);
                stack.push(top);
                stack.push(item);
            }
            return;
        }

        Character top = stack.pop();
        Character middle = stack.pop();
        Character last = stack.pop();

        boolean result = findIdenticalCharacter(middle, top, item);
        if (result) {
            stack.push(last);
            display(item);
            return;
        }

        result = findIdenticalCharacter(top, middle, last);
        if (result) {
            stack.push(item);
            display(item);
            return;
        }

        stack.push(last);
        stack.push(middle);
        stack.push(top);
        stack.push(item);

    }
}
