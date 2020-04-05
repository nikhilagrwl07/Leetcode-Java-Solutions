/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.realTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairInDifferentArrayWithClosestSumLessThanEqualToK {
    public static void main(String[] args) {

        List<List<Integer>> foreground = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 5),
                Arrays.asList(3, 7),
                Arrays.asList(4, 10));

        List<List<Integer>> background = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 5));
        int deviceCapacity = 5;

        FindPairInDifferentArrayWithClosestSumLessThanEqualToK ob = new FindPairInDifferentArrayWithClosestSumLessThanEqualToK();
        List<List<Integer>> pairWithClosestSumLessThanToK = ob.findPairWithOptimalSpace(foreground, background, deviceCapacity);
        System.out.println(pairWithClosestSumLessThanToK);

    }

    // Time Complexity - O(size of foregroundAppList * size of backgroundAppList)
    // Space Complexity - O(1) (Only used closestSumTillNow variable and not considering size of output List<List<Integer>> result)
    public List<List<Integer>> findPairWithOptimalSpace(List<List<Integer>> foregroundAppList,
                                                        List<List<Integer>> backgroundAppList
            , int deviceCapacity) {

        if (foregroundAppList == null || foregroundAppList.isEmpty()
                || backgroundAppList == null || backgroundAppList.isEmpty() || deviceCapacity <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        int closestSumTillNow = Integer.MAX_VALUE;

        // for each foreground process
        for (int f = 0; f < foregroundAppList.size(); f++) {

            // for each background process
            for (int b = 0; b < backgroundAppList.size(); b++) {

                // if foreground memory size +  background memory size <= total device Capacity
                if (foregroundAppList.get(f).get(1) + backgroundAppList.get(b).get(1) <= deviceCapacity) {

                    if (deviceCapacity - (foregroundAppList.get(f).get(1) + backgroundAppList.get(b).get(1)) < closestSumTillNow) {
                        result.clear();
                        result.add(Arrays.asList(f + 1, b + 1));
                        closestSumTillNow = deviceCapacity - (foregroundAppList.get(f).get(1) + backgroundAppList.get(b).get(1));
                    } else if (deviceCapacity - (foregroundAppList.get(f).get(1) + backgroundAppList.get(b).get(1)) == closestSumTillNow) {
                        result.add(Arrays.asList(f + 1, b + 1));
                    }
                }
            }
        }
        return result;
    }

}
