public class MinPathSum {
    /**
     * 题号名称：64. 最小路径和
     * 题目链接：https://leetcode-cn.com/problems/minimum-path-sum/
     * 算法思路：动态规划
     * 1）最优子结构：dp[i][j] = min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j]
     * 2）中间状态：dp[i][j]，表示从左上角到grid[i][j]格子的最短路径和
     * 3）DP方程：
     *   dp[i][j] = grid[0][0], (i == 0, j == 0)
     *   dp[i][j] = dp[i][j - 1] + grid[i][j], (i == 0, j != 0)
     *   dp[i][j] = dp[i - 1][j] + grid[i][j], (i != 0, j == 0)
     *   dp[i][j] = min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j], (i != 0, j != 0)
     * 时间复杂度：O(MN)
     * 空间复杂度：O(MN)，可以复用上一行的dp，空间复杂度优化为O(N)
     */
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        /* 二维dp数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
        */
        // 复用上一行的dp值，优化空间复杂度
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}

