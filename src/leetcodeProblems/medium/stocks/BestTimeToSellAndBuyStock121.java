package leetcodeProblems.medium.stocks;

import java.util.Stack;

public class BestTimeToSellAndBuyStock121 {
    public static void main(String[] args) {
        BestTimeToSellAndBuyStock121 ob = new BestTimeToSellAndBuyStock121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {1, -1};
        int maxProfit = ob.maxProfit(prices);
//        int maxProfit2 = ob.maxProfit(prices2);
//        int maxProfit3 = ob.maxProfit(prices3);
        System.out.println(maxProfit);
//        System.out.println(maxProfit2);
//        System.out.println(maxProfit3);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int maxProfit = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        s.push(prices[0]);

        for (int i = 1; i < prices.length; i++) {

            while (!s.isEmpty() && s.peek() >= prices[i]) {
                s.pop();
            }

            if (!s.isEmpty()) {
                int curretMax = s.peek();
                maxProfit = Math.max(maxProfit, prices[i] - curretMax);
            }

            if (s.isEmpty() || s.peek() > prices[i])
                s.push(prices[i]);
        }

        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
}
