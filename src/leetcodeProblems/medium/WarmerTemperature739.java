package leetcodeProblems.medium;

import java.util.Arrays;
import java.util.Stack;

public class WarmerTemperature739 {
    public static void main(String[] args) {
        WarmerTemperature739 ob = new WarmerTemperature739();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] T = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] dailyTemperatures = ob.dailyTemperatures(T);
        System.out.println(Arrays.toString(dailyTemperatures));
    }

    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> s = new Stack<>();
        int[] result = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && T[s.peek()] <= T[i]) {
                s.pop();
            }

            if (s.isEmpty())
                result[i] = 0;
            else
                result[i] = s.peek() - i;

            s.push(i);
        }

        return result;
    }
}
