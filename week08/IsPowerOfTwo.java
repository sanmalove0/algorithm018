public class IsPowerOfTwo {
    /**
     * 题号名称：231. 2的幂
     * 题目链接：https://leetcode-cn.com/problems/power-of-two/
     * 算法思路：2的幂次方的二进制表示中有且只有一位为1，位运算特性 X = X & (X - 1) 清零最低位的1
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
