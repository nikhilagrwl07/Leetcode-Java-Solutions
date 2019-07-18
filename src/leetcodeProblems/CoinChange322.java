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
        int[] coins = {1, 2, 5};
        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

//        int[] coins = {1, 2};
//        int amount = 2;

//        int[] coins = {3};
//        int amount = 10;

//        int[] coins = {474, 83, 404, 3};
//        int amount = 264;

        int coinsRequired = ob.coinChange(coins, amount);
        System.out.println(coinsRequired);

    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0)
            return -1;


        Arrays.sort(coins);

        if(amount < coins[0])
            return -1;

        int[] coinsRequired = new int[amount + 1];
        coinsRequired[0] = 0;

        for (int c = 0; c < coins.length; c++) {
            if (coins[c] <= amount) {
                coinsRequired[coins[c]] = 1;
            }
        }

        for (int a = 1; a <= amount; a++) {

            int minNumberOfCoinsRequiredToFillAmounta = Integer.MAX_VALUE;

            for (int coin : coins) {

                if (coin <= a && coinsRequired[a] != 1 && coinsRequired[a - coin] > 0) {
                    minNumberOfCoinsRequiredToFillAmounta = Math.min(minNumberOfCoinsRequiredToFillAmounta, coinsRequired[a - coin] + 1);
                }
            }

            if (minNumberOfCoinsRequiredToFillAmounta != Integer.MAX_VALUE) {
                coinsRequired[a] = minNumberOfCoinsRequiredToFillAmounta;
            }
        }

        if (coinsRequired[amount] == 0) {
            return -1;
        }
        return coinsRequired[amount];
    }


}
