import java.util.*;

public class NumIslands {
    /**
     * 题号名称：200. 岛屿数量
     * 题目链接：https://leetcode-cn.com/problems/number-of-islands/
     * 算法思路：广度优先遍历
     * 时间复杂度：O(MN)
     * 空间复杂度：O(MN)
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        Deque<Integer> iq = new ArrayDeque<Integer>();
        Deque<Integer> jq = new ArrayDeque<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    iq.clear();
                    jq.clear();
                    iq.push(i);
                    jq.push(j);
                    while (!iq.isEmpty()) {
                        int a = iq.pollFirst();
                        int b = jq.pollFirst();
                        grid[a][b] = '0';
                        if (a - 1 >= 0 && grid[a - 1][b] == '1') {
                            iq.push(a - 1);
                            jq.push(b);
                        }
                        if (b + 1 < n && grid[a][b + 1] == '1') {
                            iq.push(a);
                            jq.push(b + 1);
                        }
                        if (a + 1 < m && grid[a + 1][b] == '1') {
                            iq.push(a + 1);
                            jq.push(b);
                        }
                        if (b - 1 >= 0 && grid[a][b - 1] == '1') {
                            iq.push(a);
                            jq.push(b - 1);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}

