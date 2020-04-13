package leetcodeProblems.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ImplementStackUsingQueue225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
//        int pop = stack.pop();
//        System.out.println(pop);

//        stack.push(3);
//        pop = stack.pop();
//        System.out.println(pop);
//        pop = stack.pop();
//        System.out.println(pop);

        System.out.println(stack.top());
        System.out.println(stack.pop());

    }
}

class MyStack {

    LinkedList<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int size = q.size();
        q.add(x);

        while (size > 0) {
            q.add(q.remove());
            size--;
        }

    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.size() == 0;
    }
}

