import java.util.*;

public class Permute {
    /**
     * 题号名称：46. 全排列
     * 题目链接：https://leetcode-cn.com/problems/permutations/
     * 算法思路：回溯
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            tmpList.add(nums[i]);
        }
        dfs(len, 0, tmpList, list);
        return list;
    }

    public void dfs(int len, int start, List<Integer> tmpList, List<List<Integer>> list) {
        if (start == len) {
            list.add(new ArrayList<Integer>(tmpList));
        }
        for (int i = start; i < len; i++) {
            Collections.swap(tmpList, start, i);
            dfs(len, start + 1, tmpList, list);
            Collections.swap(tmpList, start, i);
        }
    }
}
