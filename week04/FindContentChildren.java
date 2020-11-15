import java.util.Arrays;

public class FindContentChildren {
    /**
     * 题号名称：455. 分发饼干
     * 题目链接：https://leetcode-cn.com/problems/assign-cookies/
     * 算法思路：排序+贪心
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(logN)
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length) {
            while (j < s.length && g[i] > s[j]) {
                j++;
            }
            if (j == s.length) {
                return i;
            }
            i++;
            j++;
        }
        return i;
    }
}

