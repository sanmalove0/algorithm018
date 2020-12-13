import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    /**
     * 题号名称：146. LRU 缓存机制
     * 题目链接：https://leetcode-cn.com/problems/lru-cache/
     * 算法思路：
     * 1. 利用哈希表+链表实现的LinkedHashMap；
     * 2. 键值对按照accessOrder（即访问先后顺序）进行排列，符合最近最少使用的特性；
     * 3. 重写removeEldestEntry方法，使得键值对个数达到capacity后，新的插入会置换掉最老的元素；
     * 4. 最好能自己实现LinkedHashMap
     * 时间复杂度：O(1)
     * 空间复杂度：O(N)
     */
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
