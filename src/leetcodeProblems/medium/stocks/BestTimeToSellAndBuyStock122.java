package leetcodeProblems.medium.stocks;

public class BestTimeToSellAndBuyStock122 {
    public static void main(String[] args) {
        BestTimeToSellAndBuyStock122 ob = new BestTimeToSellAndBuyStock122();
//                              2
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {1, -1};
        int[] prices4 = {1, 2, 3, 4, 5};
        int[] prices5 = {2, 4, 1};
        int[] prices6 = {1, 3, 2, 8, 4, 9};
//        int maxProfit = ob.maxProfit(prices);
//        int maxProfit2 = ob.maxProfit(prices2);
//        int maxProfit3 = ob.maxProfit(prices3);
//        int maxProfit4 = ob.maxProfit(prices4);
//        int maxProfit5 = ob.maxProfit(prices5);
        int maxProfit6 = ob.maxProfit(prices6);

//        System.out.println(maxProfit);
//        System.out.println(maxProfit2);
//        System.out.println(maxProfit3);
//        System.out.println(maxProfit4);
//        System.out.println(maxProfit5);
        System.out.println(maxProfit6);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int totalProfit = 0;
        int maxProfit = 0;

        Integer currentLowest = null;
        Integer currentHighest = null;

        for (int i = 0; i < prices.length; i++) {

            if (currentLowest == null || (currentLowest > prices[i] && currentHighest == null)) {
                currentLowest = prices[i];
                continue;
            }

            if ((currentLowest != null) && (currentHighest == null || currentHighest < prices[i])){
                currentHighest = prices[i];
                continue;
            }

            if (prices[i] < currentHighest) {
                // time to sell
                maxProfit = currentHighest - currentLowest;
                totalProfit += maxProfit;
                currentLowest = prices[i];
                currentHighest = null;
            }
        }

        if (currentLowest != null && currentHighest != null && currentLowest < currentHighest) {
            maxProfit = currentHighest - currentLowest;
            totalProfit += maxProfit;
        }
        return totalProfit;
    }
}
