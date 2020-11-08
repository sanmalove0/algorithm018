import java.util.*;

public class PermuteUnique {
    /**
     * 题号名称：47. 全排列 II
     * 题目链接：https://leetcode-cn.com/problems/permutations-ii/
     * 算法思路：回溯
     * 1.处理组合问题或者可能有重复的排列问题，为保证结果不重复，先对数组进行排序；
     * 2.boolean[] visited 数组用来标记当前元素是否被访问过；
     * 3.对于连续重复的元素，只取左起第一个未被访问的元素；
     * 时间复杂度：O(N*N!)
     * 空间复杂度：O(N)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, 0, tmpList, list, visited);
        return list;
    }

    public void backtrack(int[] nums, int start, List<Integer> tmpList, List<List<Integer>> list, boolean[] visited) {
        if (start == nums.length) {
            list.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            tmpList.add(nums[i]);
            visited[i] = true;
            backtrack(nums, start + 1, tmpList, list, visited);
            tmpList.remove(start);
            visited[i] = false;
        }
    }
}

