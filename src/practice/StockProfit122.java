package practice;

public class StockProfit122 {
    public static void main(String[] args) {

        StockProfit122 ob = new StockProfit122();
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {3,2,6,5,0,3};

        System.out.println(ob.maxProfit(prices));
//        System.out.println(ob.maxProfit(prices2));
        System.out.println(ob.maxProfit(prices3));
    }

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        Integer buy = -prices[0], sell = null, hold = null, noAction = 0;
        int maxProfit = 0;


        for (int i = 1; i < prices.length; i++) {

            int tmpBuy;

            if (sell != null)
                tmpBuy = Math.max(noAction - prices[i], Math.max(-prices[i], sell - prices[i]));
            else
                tmpBuy = Math.max(noAction - prices[i], -prices[i]);

            int tmpSell;

            if (hold != null)
                tmpSell = Math.max(hold, buy) + prices[i];
            else
                tmpSell = buy + prices[i];

            int tmpHold;

            if (hold != null)
                tmpHold = Math.max(hold, buy);
            else
                tmpHold = buy;

            int tmpNoAction = Math.max(noAction, Math.max(buy, tmpSell));

            buy = tmpBuy;
            sell = tmpSell;
            hold = tmpHold;
            noAction = tmpNoAction;

            maxProfit = Math.max(maxProfit, sell);
        }

        return maxProfit;

    }

}
