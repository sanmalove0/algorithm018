public class ReverseBits {
    /**
     * 题号名称：190. 颠倒二进制位
     * 题目链接：https://leetcode-cn.com/problems/reverse-bits/
     * 算法思路：利用位运算特性，从n的二进制表示的最低位起，依次获取当前位的值，在res左移一位后追加到res最右侧，n再右移一位
     * n & 1 得到n的二进制表示的最低位
     * << 二进制位左移
     * >> 二进制位右移
     * 时间复杂度：O(N) N为32
     * 空间复杂度：O(1)
     */
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
}
