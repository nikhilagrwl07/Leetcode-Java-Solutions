package leetcodeProblems.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII503 {
    public static void main(String[] args) {
        NextGreaterElementII503 ob = new NextGreaterElementII503();
        int[] a1 = {1, 2, 1};
        int[] a2 = {4, 2, 14, 6, 8, 1};
        int[] a3 = {1, 2, 3, 4, 5};
        int[] a4 = {1, 1, 1};
        System.out.println(Arrays.toString(ob.nextGreaterElements(a1)));
//        System.out.println(Arrays.toString(ob.nextGreaterElements(a2)));
//        System.out.println(Arrays.toString(ob.nextGreaterElements(a3)));
//        System.out.println(Arrays.toString(ob.nextGreaterElements(a4)));
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];

        Stack<Integer> st = new Stack<>();
        int index = 0;
        st.push(index);
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        boolean isOnetraversalComplete = false;

        while (!st.isEmpty()) {
            index = (index + 1) % nums.length;

            if (st.peek() == index) {
                break;
            }
            while (!st.isEmpty() && nums[st.peek()] < nums[index]) {
                result[st.peek()] = nums[index];
                st.pop();
            }
            if (result[index] < 0 && !isOnetraversalComplete)
                st.push(index);

            if (index == nums.length - 1)
                isOnetraversalComplete = true;
        }

        return result;
    }
}
