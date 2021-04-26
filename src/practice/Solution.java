package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(0, 20);
        list.add(1, 15);
        System.out.println(list);
//        int[] a = {1, 2, 3};
//        int[] a = {1,2,3, 5,6,7};
//        int[] a = {1,1,1};
//        int[] a = {0,-1,1};
//        int[] a = {1};
//        int[] a = {2};
//        int[] a = {-1,-3};
//        int[] a = {1, 3, 6, 4, 1, 2};
//        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        // sort input array
        Arrays.sort(A);

        Integer startNumber = null;
        for (int i = 0; i < A.length; i++) {

            if (A[i] > 0) {
                if (startNumber == null) {
                    startNumber = A[i];
                } else {

                    if (A[i] == startNumber + 1) {
                        startNumber++;
                    } else if (A[i] > startNumber) {
                        return startNumber + 1;
                    }

                }
            }
        }
        if (A[A.length - 1] <= 0)
            return 1;

        if (A.length == 1) {
            if(A[0] > 1)
                return 1;
            else
                return A[0]+1;
        }

        return A[A.length - 1] + 1;
    }
}
