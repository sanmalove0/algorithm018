public class FindMin {
    /**
     * 题号名称：53. 寻找旋转排序数组中的最小值
     * 题目链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
     * 算法思路：二分查找
     * 1). 当nums[mid]比它前面的元素小的时候，mid恰为数组中间的无序位置；
     * 2). 当mid等于0，或者nums[mid]大于nums[0]时，mid位于前半段有序数组中，则搜索的左边界变成mid+1；
     * 3). 当nums[mid]小于nums[len-1]时，mid位于后半段有序数组中，则搜索的右边界变成mid；
     * 4). 当数组中只有一个元素时，返回nums[0]；
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else if (nums[mid] < nums[len - 1]) {
                right = mid;
            }
        }
        return nums[0];
    }
}

