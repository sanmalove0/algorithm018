class TwoSum {
    /**
     * 题号名称：1. 两数之和
     * 题目链接：https://leetcode-cn.com/problems/two-sum/description/
     * 算法思路：
     * （1) 哈希表
     *  思路：key是数组元素到值，value是元素下标，利用HashMap的containsKey方法快速查找是否有与当前元素相加等于target的其他元素
     *  时间复杂度：O(N)
     *  空间复杂度：O(N)
     * （2）暴力法
     *  时间复杂度：O(N^2)
     *  空间复杂度：O(1)
     */
    public static int[] twoSum(int[] nums, int target) {
        // 哈希表
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];*/
        // 暴力法
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
