import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    /**
     * 题号名称：56. 合并区间
     * 题目链接：https://leetcode-cn.com/problems/merge-intervals/
     * 算法思路：区间根据左边界排序后，将有重合的区间进行合并
     * 时间复杂度：O(NlogN) java自带排序算法时间复杂度
     * 空间复杂度：O(NlogN) java自带排序算法空间复杂度
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        // 根据区间左边界从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt((int[] nums) -> nums[0]));  // jdk1.8的Comparator
        int[] curInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {  // 遍历区间数组
            if (intervals[i][0] > curInterval[1]) {   // 如果下一个区间左边界比当前区间右边界大，将当前区间添加到list
                list.add(curInterval);
                curInterval = intervals[i];
            } else {                                  // 如果下一个区间左边界小于等于当前区间右边界，合并，调整当前区间右边界的值
                curInterval[1] = Math.max(curInterval[1], intervals[i][1]);
            }
        }
        list.add(curInterval);
        return list.toArray(new int[list.size()][2]);  // list转数组
    }
}
