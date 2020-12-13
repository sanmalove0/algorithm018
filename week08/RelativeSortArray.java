import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
    /**
     * 题号名称：1122. 数组的相对排序
     * 题目链接：https://leetcode-cn.com/problems/relative-sort-array/
     * 算法思路：计数排序？
     * 时间复杂度：O(NlogN) java自带排序算法的时间复杂度为O(NlogN)，后面for循环的时间复杂度都是O(N),N为arr1元素个数
     * 空间复杂度：O(K) K为arr2中元素个数
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) { // arr2中元素为key，在arr1中出现次数为value
            map.put(arr2[i], 0);
        }
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }
        }
        int j = arr1.length - 1;
        for (int i = arr1.length - 1; i >= 0; i--) { // 将在arr1中，不在arr2中的元素，按顺序放在arr1后几位
            if (!map.containsKey(arr1[i])) {
                arr1[j--] = arr1[i];
            }
        }
        j = 0;
        int k = 0;
        for (int i = 0; i < arr2.length; i++) { // 遍历arr2每个元素
            k = 0;
            while (k < map.get(arr2[i])) { // 按照在map中存放的出现次数依次放到arr1中
                arr1[j++] = arr2[i];
                k++;
            }
        }
        return arr1;
    }
}
