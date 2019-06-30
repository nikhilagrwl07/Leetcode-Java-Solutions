/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class CoinChange322 {
    public static void main(String[] args) {
        CoinChange322 ob = new CoinChange322();
//        int[] coins = {1, 2, 5};
//        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

//        int[] coins = {1, Integer.MAX_VALUE};
//        int amount = 2;

//        int[] coins = {3};
//        int amount = 10;

        int[] coins = {474, 83, 404, 3};
//        int[] coins = {3, 83,404,474};
        int amount = 264;

        int coinsRequired = ob.coinChange(coins, amount);
        System.out.println(coinsRequired);

    }

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0 || amount == 0)
            return 0;

        Arrays.sort(coins);

        if (amount < coins[0])
            return -1;

        int[] coinsRequired = new int[amount + 1];
        coinsRequired[0] = 0;


        // given
        for (int i = 0; i < coins.length; i++) {

            if (coins[i] <= amount) {
                coinsRequired[coins[i]] = 1;
            }
        }

        for (int a = 1; a <= amount; a++) {
            int coinRequired = coinsRequired[a];
            if (coinRequired != 1) {
                int min = Integer.MAX_VALUE;
                for (int c = 0; c < coins.length; c++) {

                    if (a - coins[c] > 0 && (coinsRequired[a - coins[c]] > 0) &&
                            min > (coinsRequired[a - coins[c]] + 1)) {
                        min = coinsRequired[a - coins[c]] + 1;
                    }
                }

                if (min != Integer.MAX_VALUE) {
                    coinsRequired[a] = min;
                }
            }
        }

        if (coinsRequired[amount] == 0)
            return -1;
        else
            return coinsRequired[amount];
    }
}
