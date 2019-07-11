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

public class FindPairWithSumLessThanEqualToK {
    public static void main(String[] args) {

        List<List<Integer>> foreground = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 1),
                Arrays.asList(4, 5));

        List<List<Integer>> background = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2));
        int k = 5;

        FindPairWithSumLessThanEqualToK ob = new FindPairWithSumLessThanEqualToK();
        List<List<Integer>> pairs = ob.findPairs(foreground, background, k);
        System.out.println(pairs);

    }

    public List<List<Integer>> findPairs(List<List<Integer>> foreground, List<List<Integer>> background
            , int k) {

        List<List<Integer>> result = new ArrayList<>();
        for (int f = 0; f < foreground.size(); f++) {
            for (int b = 0; b < background.size(); b++) {
                if (foreground.get(f).get(1) + background.get(b).get(1) <= k) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(f);
                    tmp.add(b);
                    result.add(tmp);
                }

            }
        }
        return result;
    }

}
