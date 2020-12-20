public class FirstUniqChar {
    /**
     * 题号名称：387. 字符串中的第一个唯一字符
     * 题目链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/
     * 算法思路：字符串操作
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
