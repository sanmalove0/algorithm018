public class IsAnagram {
    /**
     * 题号名称：242. 有效的字母异位词
     * 题目链接：https://leetcode-cn.com/problems/valid-anagram/
     * 算法思路：计数排序，比较两个string中每个字符出现的次数
     * 时间复杂度：O(N)
     * 空间复杂度：O(K) K为128
     */
    public boolean isAnagram(String s, String t) {
        // 哈希表
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
            arr[t.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
