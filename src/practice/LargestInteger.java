package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestInteger {
    public static void main(String[] args) {
        LargestInteger ob = new LargestInteger();

        int[] input = {3, 2, -12, 5, -13};
        int largestInteger = ob.largestInteger(input);
        int largestInteger2 = ob.largestIntegerApproach2(input);

        System.out.println(largestInteger);
        System.out.println(largestInteger2);

    }

    public int largestInteger(int[] input) {
        if (input == null || input.length == 0)
            return 0;

        Set<Integer> s = new HashSet<>();
        int max = Integer.MIN_VALUE;

        boolean contains = false;
        for (int i = 0; i < input.length; i++) {
            if (s.contains(-input[i])) {
                max = Math.max(max, Math.abs(input[i]));
                contains = true;
            }
            s.add(input[i]);
        }
        return contains ? max : 0;
    }


    public int largestIntegerApproach2(int[] input) {
        if (input == null || input.length == 0)
            return 0;

        Arrays.sort(input);
        int i = 0, j = input.length - 1;

        while (i < j) {
            if(-input[i] == input[j]){
                return Math.abs(input[j]);
            }
            if(Math.abs(input[i]) < Math.abs(input[j])){
                j--;
            }
            else
                i++;
        }
        return 0;
    }
}
