import java.util.*;

public class TopKFrequent {

    /**
     * 题号名称：347. 前 K 个高频元素
     * 题目链接：https://leetcode-cn.com/problems/top-k-frequent-elements/
     * 算法思路：哈希表+优先队列
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     */
    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        // 优先队列自定义comparator比较器，实现其compare方法
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            int flag = 0;

            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e1.getValue() > e2.getValue()) {
                    return -1;
                }
                return 1;
            }
            });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // 构建哈希表，key为数组元素，value为其出现频率
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        queue.addAll(map.entrySet());  // 将哈希表中元素加入优先队列，按数组元素的频率排序
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();  // 取出出现频率排前k的数组元素值
        }
        return result;
    }
}



