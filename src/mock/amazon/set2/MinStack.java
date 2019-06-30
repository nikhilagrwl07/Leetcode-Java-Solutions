package mock.amazon.set2;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.Stack;

class MinStack {

    Stack<Integer> s;
    Stack<Integer> min;

    public MinStack() {
        min = new Stack<>();
        s = new Stack<>();
    }

    public void push(int x) {

        s.push(x);

        if (min.isEmpty()) {
            min.push(x);
        } else {
            if (min.peek() < x) {
//                min.push(min.peek());
                // do nothing
            } else {
                min.push(x);
            }
        }

    }

    public void pop() {
        int poppedElement = s.pop();
        if (min.peek() == poppedElement) {
            min.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }


    public static void main(String[] args) {
        MinStack ob = new MinStack();
        ob.push(-2);
        ob.push(0);
        ob.push(-3);
        System.out.println(ob.getMin());
        ob.pop();
        System.out.println(ob.top());
        System.out.println(ob.getMin());
    }

}
