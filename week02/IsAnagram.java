import java.util.*;

class IsAnagram {
    /**
     * 题号名称：242. 有效的字母异位词
     * 题目链接：https://leetcode-cn.com/problems/valid-anagram/description/
     * 算法思路：
     * （1）哈希表
     *  时间复杂度：O(N)
     *  空间复杂度：O(1)
     * （2）排序后比较
     *  时间复杂度：O(NlogN)
     *  空间复杂度：O(N)
     */
    public boolean isAnagram(String s, String t) {
        // 哈希表
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) { // key为常用ASCII码，value为字母出现频次
            arr[s.charAt(i)]++;
            arr[t.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) { // 一加一减后看每个字母的频次是否为零
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
        // 排序后比较
        /*
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
        */
    }
}
