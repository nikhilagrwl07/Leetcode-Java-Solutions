package leetcodeProblems.medium.stocks;

public class BestTimeToSellAndBuyStockWithCooldown309 {
    public static void main(String[] args) {
        BestTimeToSellAndBuyStockWithCooldown309 ob = new BestTimeToSellAndBuyStockWithCooldown309();
        int[] prices = {1, 2, 3, 0, 2};
        int[] prices2 = {7, 1, 5, 3, 6, 4};

        System.out.println(ob.maxProfitWithHistoryOfAction(prices));
        System.out.println(ob.maxProfitWithHistoryOfAction(prices2));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] cooldown = new int[prices.length];

        int index = 0;

        sell[index] = 0;
        cooldown[index] = 0;
        buy[index] = -prices[index];

        index++;

        while (index < prices.length) {
            sell[index] = buy[index - 1] + prices[index];
            buy[index] = Math.max(buy[index - 1], cooldown[index - 1] - prices[index]);
            cooldown[index] = Math.max(cooldown[index - 1], sell[index - 1]);
            index++;
        }

        return Math.max(sell[prices.length - 1], cooldown[prices.length - 1]);
    }

    public int maxProfitWithHistoryOfAction(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int index = 0;

        int sell = 0;
        int cooldown = 0;
        int buy = -prices[index];
        int coolDownTmp;

        index++;

        while (index < prices.length) {
            coolDownTmp = Math.max(cooldown, sell);
            sell = buy + prices[index];
            buy = Math.max(buy, cooldown - prices[index]);
            cooldown = coolDownTmp;
            index++;
        }

        return Math.max(sell, cooldown);
    }
}
