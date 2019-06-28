/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class BestTimeBuyandSellStock121 {
    public static void main(String[] args) {
//        int trans[] = {7, 1, 5, 3, 6, 4};
        int trans[] = {7, 6, 4, 3, 1};
//        int trans[] = {1, 3, 2, 1, 3};

        BestTimeBuyandSellStock121 ob = new BestTimeBuyandSellStock121();
        int maxProfit = ob.maxProfitWithMultipleTransaction(trans);
        System.out.println(maxProfit);
    }


    public int maxProfitWithMultipleTransaction(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int maxProfit = 0, newProfit = 0;
        int minPrice = prices[0];


        for (int i = 1; i < prices.length; i++) {

            if (prices[i] <= minPrice) {
                minPrice = prices[i];
            }

            if (i + 1 <= prices.length - 1) {

                if (prices[i + 1] <= prices[i]) {

                    if (newProfit < (prices[i] - minPrice)) {
                        newProfit = (prices[i] - minPrice);
                        maxProfit += newProfit;
                        newProfit = 0;
                        minPrice = prices[i + 1];
                    }

                }
            } else if (i == prices.length - 1) {

                if (newProfit < (prices[i] - minPrice)) {
                    newProfit = (prices[i] - minPrice);
                    maxProfit += newProfit;
                }
            }
        }

        return maxProfit;
    }

//    public int maxProfitWithSingleTransaction(int[] prices) {
//        if (prices.length <= 1)
//            return 0;
//
//        int maxProfit = Integer.MIN_VALUE;
//        int minPrice = prices[0];
//
//
//        for (int i = 1; i < prices.length; i++) {
//
//            if (prices[i] <= minPrice) {
//                minPrice = prices[i];
//            }
//            if (maxProfit < (prices[i] - minPrice)) {
//                maxProfit = prices[i] - minPrice;
//            }
//        }
//
//        if (maxProfit == Integer.MIN_VALUE) {
//            maxProfit = 0;
//        }
//
//        return maxProfit;
//    }
}
