package practice;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange ob = new CoinChange();
        int[] coins = {2, 5};
        int amount = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        int[] coins3 = {1};
        int amount3 = 0;

        int[] coins4 = {1, 2147483647};
        int amount4 = 2;

        int[] coins5 = {1};
        int amount5 = 1;

        int[] coins6 = {186, 419, 83, 408};
        int amount6 = 6249;

        System.out.println(ob.coinChange2(coins, amount));
        System.out.println(ob.coinChange2(coins2, amount2));
        System.out.println(ob.coinChange2(coins3, amount3));
        System.out.println(ob.coinChange2(coins4, amount4));
        System.out.println(ob.coinChange2(coins5, amount5));
        System.out.println(ob.coinChange2(coins6, amount6));
    }


    public int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] sum = new int[amount + 1];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        int minCount = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == amount) {
                minCount = Math.min(minCount, p[1]);
                return minCount;
            }
            for (int i = 0; i < coins.length; i++) {
                if (p[0] + coins[i] >= 0 && p[0] + coins[i] <= amount) {
                    if (sum[p[0] + coins[i]] == 0) {
                        q.offer(new int[]{p[0] + coins[i], p[1] + 1});
                        sum[p[0] + coins[i]] = p[1] + 1;
                    }
                }
            }
        }
        return -1;
    }


    public int coinChange2(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] sum = new int[amount + 1];


        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= sum.length - 1)
                sum[coins[i]] = 1;
        }

        int index = 0;

        while (index <= amount) {

            for (int i = 0; i < coins.length; i++) {

                if (sum[index] > 0
                        && index + coins[i] <= amount &&
                        (sum[index + coins[i]] == 0 ||
                                sum[index + coins[i]] >= sum[index] + 1)) {
                    sum[index + coins[i]] = sum[index] + 1;
                }

                if (sum[sum.length - 1] > 0) {
                    return sum[sum.length - 1];
                }
            }
            index++;
        }
        return -1;
    }


}
