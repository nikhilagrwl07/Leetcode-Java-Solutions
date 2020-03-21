/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindPairWithClosestSumLessThanEqualToK {
    public static void main(String[] args) {

//        List<int[]> foreground = Arrays.asList(
//                new int[]{1, 3},
//                new int[]{2, 5},
//                new int[]{3, 7},
//                new int[]{4, 10});
//
//        List<int[]> background = Arrays.asList(
//                new int[]{1, 2},
//                new int[]{2, 3},
//                new int[]{3, 4},
//                new int[]{4, 5});
//
//        int deviceCapacity = 10;


//        List<int[]> foreground = Arrays.asList(
//                new int[]{1, 8},
//                new int[]{2, 7},
//                new int[]{3, 14});
//
//        List<int[]> background = Arrays.asList(
//                new int[]{1, 5},
//                new int[]{2, 10},
//                new int[]{3, 14});
//
//        int deviceCapacity = 20;

        List<int[]> foreground = Arrays.asList(
                new int[]{1, 8},
                new int[]{2, 15},
                new int[]{3, 9});

        List<int[]> background = Arrays.asList(
                new int[]{1, 8},
                new int[]{2, 11},
                new int[]{3, 12});

        int deviceCapacity = 20;

        FindPairWithClosestSumLessThanEqualToK ob = new FindPairWithClosestSumLessThanEqualToK();
        List<int[]> pairsWithClosestSumLessThanToK = ob.findPairWithOptimalSpace(foreground, background, deviceCapacity);

        for (int[] l : pairsWithClosestSumLessThanToK) {
            System.out.println(l[0] + " " + l[1]);
        }
    }

//    Time Complexity - O(Max (NlogN, MlogM)) where N = size of first list and M = size of second list
//    Space Complexity - O(N + M)
    public List<int[]> findPairWithOptimalSpace(List<int[]> l1, List<int[]> l2, int target) {

        if (l1 == null || l1.isEmpty() || l2 == null || l2.isEmpty()) {
            return new ArrayList<>();
        }

        Collections.sort(l1, (o1, o2) -> o1[1] - o2[1]);
        Collections.sort(l2, (o1, o2) -> o1[1] - o2[1]);

        int min = Integer.MIN_VALUE;
        int i = 0;
        int j = l2.size() - 1;
        int l1Size = l1.size() - 1;
        int l2Size = l2.size() - 1;
        List<int[]> result = new ArrayList<>();
        List<int[]> lessThanResult = new ArrayList<>();

        while (i <= l1Size && j >= 0) {
            int currentSum = l1.get(i)[1] + l2.get(j)[1];

            if (currentSum > target) {
                j--;
                continue;
            }
            if (currentSum == target) {

                while (j >= 0 && (l1.get(i)[1] + l2.get(j)[1]) == target) {
                    result.add(new int[]{l1.get(i)[0], l2.get(j)[0]});
                    j--;
                }
                i++;
                j = l2Size;
                continue;
            }

            if (result.isEmpty() && min < currentSum) {
                min = currentSum;
                lessThanResult.clear();
                lessThanResult.add(new int[]{l1.get(i)[0], l2.get(j)[0]});
            }

            i++;
            j = l2Size;
        }

        return result.isEmpty() ? lessThanResult : result;
    }
}
