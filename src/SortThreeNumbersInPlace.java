/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 *//*



package main.java;

import java.util.Arrays;

public class SortThreeNumbersInPlace {
    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0};

        System.out.println(Arrays.toString(a));
        seggregateNumbersInPlace(a);
        System.out.println(Arrays.toString(a));

    }

    private static void seggregateNumbersInPlace(int[] a) {
        if (a == null || a.length <= 1)
            return;

        int low = 0, high = a.length - 1;
        int zeroIndex = -1, twoIndex = a.length, oneIndexStart = -1, oneIndexEnd = -1;

        while (low <= high) {

            if (a[low] == 0) {

                a[++zeroIndex] = 0;

                if(oneIndexStart == -1){
                            continue;
                }
                else
                {
                    oneIndexStart = shiftOnesByOne(a, zeroIndex, oneIndexEnd, twoIndex);
                    oneIndexEnd++;
                }


            } else if (a[low] == 1) {

                if(low == 0){
                    oneIndexStart++;
                    oneIndexEnd++;
                }
                else if (oneIndexEnd + 1 < twoIndex) {
                    a[++oneIndexEnd] = 1;
                }

            } else {
                if (twoIndex - 1 > oneIndexEnd)
                {
                    a[--twoIndex] = 2;
                }
            }

            low++;
        }



    }

    private static int shiftOnesByOne(int[] a, int oneIndexStart, int oneIndexEnd, int twoIndex) {
        if (oneIndexEnd == -1)
            return -1;

        if (oneIndexEnd + 1 < twoIndex) {
            for (int i = oneIndexEnd; i >= oneIndexStart; i--) {
                a[i + 1] = a[i];
            }
            return oneIndexStart + 1;
        } else {
            return -1;
        }
    }
}
*/
