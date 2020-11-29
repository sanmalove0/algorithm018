public class MaximalSquare {
    /**
     * 题号名称：221. 最大正方形
     * 题目链接：https://leetcode-cn.com/problems/maximal-square/
     * 算法思路：动态规划
     * 1）最优子结构：dp[i][j] = min(当前位置向上连续为'1'的个数的平方,
     *                            当前位置向左连续为'1'的个数的平方,
     *                            dp[i-1][j-1])
     * 2）中间状态：dp[i][j]，表示当前位置为正方形右下角时的最大面积
     * 3）DP方程：
     * dp[i][j] = 0; (matrix[i][j] == '0')
     * dp[i][j] = 1; (matrix[i][j] == '1', dp[i-1][j-1] == 0)
     * dp[i][j] = min(当前位置向上连续为'1'的个数的平方,
     *                当前位置向左连续为'1'的个数的平方,
     *                dp[i-1][j-1]); (matrix[i][j] == '1', dp[i-1][j-1] > 0)
     * 时间复杂度：O(M*N*min(M,N))
     * 空间复杂度：O(MN)
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1;
                    if (dp[i - 1][j - 1] > 0) {
                        int tmp = (int)Math.sqrt(dp[i - 1][j - 1]);
                        dp[i][j] = check(matrix, i - 1, j - 1, tmp);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
    public int check(char[][] matrix, int m, int n, int tmp) {
        int i = m - 1;
        while (i >= m - tmp) {
            if (matrix[i][n] == '0') {
                break;
            }
            i--;
        }
        int j = n - 1;
        while (j >= n - tmp) {
            if (matrix[m][j] == '0') {
                break;
            }
            j--;
        }
        int min = Math.min(m - i, n - j);
        return min * min;
    }
}

