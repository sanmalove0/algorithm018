public class ReverseStr {
    /**
     * 题号名称：541. 反转字符串 II
     * 题目链接：https://leetcode-cn.com/problems/reverse-string-ii/
     * 算法思路：字符串翻转
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     */
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int cnt = n / k;
        for (int i = 0; i < (cnt + 1) / 2; i++) {
            reverseArr(arr, 2 * i * k, k);
        }
        if (cnt % 2 == 0) {
            reverseArr(arr, n - n % k, n % k);
        }
        return String.valueOf(arr);
    }

    public void reverseArr(char[] arr, int begin, int k) {
        for (int i = begin; i < begin + k / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[2 * begin + k - i - 1];
            arr[2 * begin + k - i - 1] = temp;
        }
    }
}
