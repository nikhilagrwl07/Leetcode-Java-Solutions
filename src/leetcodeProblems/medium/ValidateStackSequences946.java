package leetcodeProblems.medium;

import java.util.Stack;

public class ValidateStackSequences946 {
    public static void main(String[] args) {
        ValidateStackSequences946 ob = new ValidateStackSequences946();
        int[] push1 = {1, 2, 3, 4, 5}, pop1 = {4, 5, 3, 2, 1};
        int[] push2 = {1, 2, 3, 4, 5}, pop2 = {4,3,5,1,2};
        int[] push3 = {1,0}, pop3 = {1,0};
        System.out.println(ob.validateStackSequences(push1, pop1));
        System.out.println(ob.validateStackSequences(push2, pop2));
        System.out.println(ob.validateStackSequences(push3, pop3));
    }

    //  pushed = [1,2,3,4,5],
    //  popped = [4,5,3,2,1]
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed.length == 0)
            return true;


        int push = 0, pop = 0;
        Stack<Integer> s = new Stack<>();

        // putting all element of push into stack
        while (push <= pushed.length - 1) {

            s.push(pushed[push]);

            if (pushed[push] != popped[pop]) {
                push++;
            } else {

                s.pop();
                pop++;
                push++;

                 while (pop <= popped.length-1 && !s.isEmpty() && popped[pop]==s.peek()){
                     s.pop();
                     pop++;
                 }
            }
        }

        // popping all element from stack and checking with pop array
        while (!s.isEmpty() && pop <= popped.length - 1) {
            if (s.pop() != popped[pop])
                return false;
            pop++;
        }
        return true;
    }
}
