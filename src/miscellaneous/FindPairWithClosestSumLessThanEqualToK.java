/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairWithClosestSumLessThanEqualToK {
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
        int deviceCapacity = 10;

        FindPairWithClosestSumLessThanEqualToK ob = new FindPairWithClosestSumLessThanEqualToK();
        List<List<Integer>> pairWithClosestSumLessThanToK = ob.findPairWithOptimalSpace(foreground, background, deviceCapacity);
        System.out.println(pairWithClosestSumLessThanToK);

    }

    public List<List<Integer>> findPairWithOptimalSpace(List<List<Integer>> foreground, List<List<Integer>> background
            , int k) {

        List<List<Integer>> result = new ArrayList<>();
        int closestSumTillNow = Integer.MAX_VALUE;
        for (int f = 0; f < foreground.size(); f++) {
            for (int b = 0; b < background.size(); b++) {

                if (foreground.get(f).get(1) + background.get(b).get(1) <= k) {

                    if (k - (foreground.get(f).get(1) + background.get(b).get(1)) < closestSumTillNow) {
                        result.clear();
                        result.add(Arrays.asList(f + 1, b + 1));
                        closestSumTillNow = k - (foreground.get(f).get(1) + background.get(b).get(1));
                    } else if (k - (foreground.get(f).get(1) + background.get(b).get(1)) == closestSumTillNow) {
                        result.add(Arrays.asList(f + 1, b + 1));
                    }
                }
            }
        }
        return result;
    }

}
