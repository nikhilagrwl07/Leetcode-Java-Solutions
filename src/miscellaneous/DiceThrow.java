/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import java.util.Arrays;

public class DiceThrow {
    public static void main(String[] args) {

//        int m = 2, n = 2, x = 3;
//        int m = 6, n = 3, x = 8;
//        int m = 4, n = 2, x = 5;
        int m = 4, n = 3, x = 5;

        DiceThrow ob = new DiceThrow();
        int numberOfWaysToFindSumK = ob.numberOfWaysToFindSumK(n, m, x);
        System.out.println(numberOfWaysToFindSumK);
    }

    public int numberOfWaysToFindSumK(int n, int m, int sum) {

        if (n == 0 || m == 0 || sum <= 0)
            return 0;
        if (sum > n * m)
            return 0;

        int[] diceValue = new int[n + 1];
        diceValue[0] = 0;

        for (int i = 1; i <= n; i++) {
            diceValue[i] = 1;
        }

        return numberOfWaysToFindSumKUtil(diceValue, m, sum);
    }

    public int numberOfWaysToFindSumKUtil(int[] diceValue, int m, int sum) {

        if (0 == sum) {
            return 1;
        }

        if (sum < 0)
            return 0;

        int ways = 0;

        for (int i = 1; i <= diceValue.length-1; i++) {

            // ignoring
            int calculateSum = calculateSum(diceValue);
            int waysTmp = numberOfWaysToFindSumKUtil(diceValue, m, sum - calculateSum);

            ways += waysTmp;

            if (diceValue[i] + 1 <= m) {
                diceValue[i] += 1;

                // taking
                calculateSum = calculateSum(diceValue);
                ways += numberOfWaysToFindSumKUtil(diceValue, m, sum - calculateSum);

                //reverting
                diceValue[i]--;
            }
        }
        return ways;
    }

    private int calculateSum(int[] diceValue) {
        return Arrays.stream(diceValue, 1, diceValue.length).sum();
    }
}
