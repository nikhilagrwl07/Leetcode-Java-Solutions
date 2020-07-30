package practice;

public class StockProfit121 {
    public static void main(String[] args) {

        StockProfit121 ob = new StockProfit121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7,6,4,3,1};

        System.out.println(ob.maxProfit(prices));
        System.out.println(ob.maxProfit(prices2));
    }

    public int maxProfit(int[] prices) {

        if(prices==null || prices.length==0)
            return 0;

        Integer buy = -prices[0], sell = null, hold = null, noAction = 0;
        int maxProfit = 0;


        for (int i = 1; i < prices.length; i++) {
            int tmpBuy = Math.max(noAction - prices[i], -prices[i]);

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

            int tmpNoAction = Math.max(noAction, buy);

            buy = tmpBuy;
            sell = tmpSell;
            hold = tmpHold;
            noAction = tmpNoAction;

            maxProfit = Math.max(maxProfit, sell);
        }

        return maxProfit;

    }

}
