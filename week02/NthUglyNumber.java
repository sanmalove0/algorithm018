import java.util.PriorityQueue;

public class NthUglyNumber {
    /**
     * 题号名称：264. 丑数 II
     * 题目链接：https://leetcode-cn.com/problems/ugly-number-ii/
     * 算法思路：优先队列
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     */
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> queue = new PriorityQueue<>(); // 注意：用int的话会越界
        queue.offer(1L);
        int result;
        for (int i = 2; i <= n; i++) {
            result = queue.poll().intValue();
            if (!queue.contains(result * 2L)) {
                queue.offer(result * 2L);
            }
            if (!queue.contains(result * 3L)) {
                queue.offer(result * 3L);
            }
            if (!queue.contains(result * 5L)) {
                queue.offer(result * 5L);
            }
        }
        result = queue.poll().intValue();
        return result;
    }
}

