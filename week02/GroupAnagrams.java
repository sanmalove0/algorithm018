import java.util.*;

class GroupAnagrams {
    /**
     * 题号名称：49. 字母异位词分组
     * 题目链接：https://leetcode-cn.com/problems/group-anagrams/
     * 算法思路：哈希表，key为排序后的字符串，value为排序前的str组成的list
     * 时间复杂度：O(NKlogK)，N为strs数组的大小，K为strs中单个字符串的长度
     * 空间复杂度：O(NK)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 哈希表
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            String key = String.valueOf(chArr);
            if (map.containsKey(key)) {
                List<String> l = map.get(key);
                l.add(strs[i]);
                map.put(key, l);
            } else {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                map.put(key, l);
            }
        }
        return new ArrayList<>(map.values());
    }
}

