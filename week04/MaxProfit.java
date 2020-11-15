public class MaxProfit {
    /**
     * 题号名称：122. 买卖股票的最佳时机 II
     * 题目链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     * 算法思路：贪心算法
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            sum += Math.max(0, prices[i + 1] - prices[i]);
        }
        return sum;
    }
}

