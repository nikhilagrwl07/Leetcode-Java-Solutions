package practice;

public class StockProfit309 {
    public static void main(String[] args) {

        StockProfit309 ob = new StockProfit309();
        int[] prices = {1, 2, 3, 0, 2};

        System.out.println(ob.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        Integer buy = -prices[0], sell = null, hold = null, noAction = 0;
        int maxProfit = 0;


        for (int i = 1; i < prices.length; i++) {

            int tmpBuy = noAction - prices[i];

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

            int tmpNoAction;

            if (sell != null)
                tmpNoAction = Math.max(noAction, sell);
            else
                tmpNoAction = noAction;

            buy = tmpBuy;
            sell = tmpSell;
            hold = tmpHold;
            noAction = tmpNoAction;
        }


        int result = noAction;
        if (sell != null) {
            result = Math.max(result, sell);
        }
        if (hold != null) {
            result = Math.max(result, hold);
        }
        return result;
    }

}
