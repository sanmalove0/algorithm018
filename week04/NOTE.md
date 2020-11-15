学习笔记
使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方
* 思路：
    1. 当nums[mid]比它前面的元素小的时候，mid恰为数组中间的无序位置；
    2. 当 mid == 0 或者 nums[mid] > nums[0] 时，mid位于前半段有序数组中，则搜索的左边界变成mid+1；
    3. 当 nums[mid] < nums[len - 1]时，mid位于后半段有序数组中，则搜索的右边界变成mid；
* 代码：

        public class FindTheDisorderPos {
            public static int findTheDisorderPos(int[] nums) {

                int len = nums.length;
                int left = 0;
                int right = len - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (mid != 0 && nums[mid] < nums[mid - 1]) {
                        return mid;
                    } else if (nums[mid] >= nums[0]) {
                        left = mid + 1;
                    } else if (nums[mid] < nums[len - 1]) {
                        right = mid;
                    }
                }
                return 0;
            }
            public static void main(String[] args) {
                int[] nums = new int[]{5, 6, 7, 0, 1, 2, 4};
                System.out.println(findTheDisorderPos(nums));
            }
        }
