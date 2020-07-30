package practice;

public class StockProfit714 {
    public static void main(String[] args) {

        StockProfit714 ob = new StockProfit714();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(ob.maxProfit(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {

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
                tmpSell = Math.max(hold, buy) + prices[i] - fee;
            else
                tmpSell = buy + prices[i] - fee;

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
