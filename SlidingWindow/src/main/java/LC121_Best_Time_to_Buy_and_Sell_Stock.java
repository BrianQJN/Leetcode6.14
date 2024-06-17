/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        // initialize the sliding window and max profit
        int left = 0, right = 1;
        int maxProfit = 0;

        // move the window to find the max profit
        while (right < prices.length) {
            if (prices[left] <= prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
