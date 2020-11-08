import java.util.*;

class Combine {
    /**
     * 题号名称：77. 组合
     * 题目链接：https://leetcode-cn.com/problems/combinations/
     * 算法思路：回溯 + 剪枝
     * 时间复杂度：O(N*N!)
     * 空间复杂度：O(N)
     */
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs(n, k, 1, stack, list);
        return list;
    }

    public void dfs(int n, int k, int start, Stack<Integer> stack, List<List<Integer>> list) {
        if (stack.size() == k) {
            list.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; k - stack.size() <= n - i + 1; i++) {
            stack.push(i);
            dfs(n, k, i + 1, stack, list);
            stack.pop();
        }
    }
}
