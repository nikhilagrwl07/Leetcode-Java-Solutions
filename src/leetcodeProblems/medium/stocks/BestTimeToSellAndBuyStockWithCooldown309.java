package leetcodeProblems.medium.stocks;

public class BestTimeToSellAndBuyStockWithCooldown309 {
    public static void main(String[] args) {
        BestTimeToSellAndBuyStockWithCooldown309 ob = new BestTimeToSellAndBuyStockWithCooldown309();
        int[] prices = {1, 2, 3, 0, 2};
//        int[] prices2 = {7, 1, 5, 3, 6, 4};

        System.out.println(ob.maxProfit(prices));
//        System.out.println(ob.maxProfit(prices2));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        Integer buy = -prices[0];
        Integer sell = null;
        Integer noAction = 0;
        Integer hold = null;

        Integer tmpbuy;
        Integer tmpsell;
        Integer tmpnoAction;
        Integer tmphold;
        for (int i = 1; i < prices.length; i++) {
            tmpbuy = Math.max(noAction - prices[i], -prices[i]);

            if (hold != null)
                tmpsell = Math.max(prices[i] + buy, prices[i] + hold);
            else
                tmpsell = prices[i] + buy;

            if (sell != null)
                tmpnoAction = Math.max(noAction, sell);
            else
                tmpnoAction = noAction;


            if (hold != null)
                tmphold = Math.max(hold, buy);
            else
                tmphold = buy;

            buy = tmpbuy;
            sell = tmpsell;
            noAction = tmpnoAction;
            hold = tmphold;

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
