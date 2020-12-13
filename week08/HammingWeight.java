public class HammingWeight {
    /**
     * 题号名称：191. 位1的个数
     * 题目链接：https://leetcode-cn.com/problems/number-of-1-bits/
     * 算法思路：位运算特性 X = X & (X - 1) 清零最低位的1
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

