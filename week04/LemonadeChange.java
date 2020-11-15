public class LemonadeChange {
    /**
     * 题号名称：860. 柠檬水找零
     * 题目链接：https://leetcode-cn.com/problems/lemonade-change/
     * 算法思路：贪心算法
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                arr[0]++;
            } else if (bills[i] == 10 && arr[0] > 0) {
                arr[1]++;
                arr[0]--;
            } else if (bills[i] == 20) {
                if (arr[1] > 0 && arr[0] > 0) {
                    arr[1]--;
                    arr[0]--;
                } else if (arr[1] == 0 && arr[0] > 2) {
                    arr[0] = arr[0] - 3;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

