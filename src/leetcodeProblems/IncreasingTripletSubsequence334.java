package leetcodeProblems;

import java.util.Stack;

public class IncreasingTripletSubsequence334 {
    public static void main(String[] args) {

        IncreasingTripletSubsequence334 ob = new IncreasingTripletSubsequence334();
//        int[] a = {1,2,3,4,5};
        int[] a = {5, 1, 5, 5, 2, 5, 4};
//        int[] a = {5, 4, 3, 2, 1};

        boolean increasingTriplet = ob.increasingTriplet(a);
        System.out.println(increasingTriplet);
    }

    public boolean increasingTriplet(int[] nums) {

        if (nums == null || nums.length < 3) {
            return false;
        }


        Stack<Integer> s = new Stack<>();
        s.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            while (!s.isEmpty() && s.peek() == nums[i]) {
                s.pop();
            }
            s.push(nums[i]);
        }

        if (s.isEmpty() || s.size() < 3) {
            return false;
        }

        int[] subseq = new int[3];
        int index = 2;
        subseq[index] = s.pop();


        while (!s.isEmpty()) {

            if (s.peek() < subseq[index]) {
                index--;
                subseq[index] = s.pop();
            } else {
                while (index <= 2 && subseq[index] <= s.peek()) {
                    index++;
                }
                if(index ==2){
                    subseq[index] = s.pop();
                }
                else{
                    index--;
                    subseq[index] = s.pop();
                }
            }

            if (index == 0) {
                return true;
            }
        }

        return false;
    }

}
