public class NumDecodings {
    /**
     * 题号名称：91. 解码方法
     * 题目链接：https://leetcode-cn.com/problems/decode-ways/
     * 算法思路：动态规划
     * 1）最优子结构：
     *  dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
     *  dp[i][1] = dp[i - 1][0];
     * 2）中间状态：
     *  dp[i][0]， 表示当前字符结尾且当前字符单独解码时，解码方法的个数；
     *  dp[i][1]， 表示当前字符结尾且当前字符与前一个字符共同解码时，解码方法的个数；
     * 3）DP方程：
     *  dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; (当前字符单独解码, s(i) != '0')
     *  dp[i][1] = dp[i - 1][0]; (当前字符与前一个字符共同解码, s(i - 1) == '1' 或 '2' 且s(i)不超过'6')
     *  注意：处理字符为'0'的情况，只能与前一个字符共同解码，不能单独解码；
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0') {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            }
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) != '7' && s.charAt(i) != '8' && s.charAt(i) != '9')) {
                dp[i][1] = dp[i - 1][0];
            }
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }
}

