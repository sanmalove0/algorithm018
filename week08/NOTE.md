学习笔记

### 第十六课 位运算

十进制转二进制：不断除以2取余数，将余数逆序排列。

#### 位运算符

| 位运算名称 | 符号 | 示例 |
| -------- | ---- | ----------- |
| 左移 | << | 0011 => 0110 |
| 右移 | >> | 0110 => 0011 |
| 按位或 | &#124; | 0011 <br> ———=> 1011 <br> 1011 |
| 按位与 | & | 0011 <br> ———=> 0011 <br> 1011 |
| 按位取反 | ~ | 0011 => 1100 |
| 按位异或 <br>（相同为零不同为一） | ^ | 0011 <br> ———=> 1000 <br> 1011 |

#### XOR - 异或
异或：相同为0，不同为1。也可以用“不进位加法”来理解。

异或操作的一些特点：
1. x ^ 0 = x
2. x ^ 1s = ~x   // 注意1s = ～0
3. x ^ (~x) = 1s
4. x ^ x = 0
5. c = a ^ b  =>  a ^ c = b, b ^ c = a   // 交换两个数
6. a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c  // associative 结合律

#### 指定位置的位运算
1. 将x最右边的n位清零：x & (~0 << n)
2. 获取x的第n位值（0或者1）：(x >> n) & 1
3. 获取x的第n位的幂值：x & (1 << n)
4. 仅将第n位置为1：x | (1 << n)
5. 仅将第n位置为0：x & (~ (1 << n))
6. 将x最高位至第n位（含）清零：x & ((1 << n) - 1)

#### 实战位运算要点
* 判断奇偶：
            x % 2 == 1  —>  (x & 1) == 1
            x % 2 == 0  —>  (x & 1) == 0
* x >> 1 —>  x / 2
            即：x = x / 2;  —>  x = x >> 1;
            mid = (left + right) / 2;  —>  mid = (left + right) >> 1;
* X = X & (X - 1) 清零最低位的1
* X & -X  =>  得到最低位的1
* X & ~X  =>  0

### 第十七课 布隆过滤器和LRU缓存

#### Bloom Filter vs Hash Table

一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。

优点：空间效率和查询时间都远远超过一般的算法

缺点：有一定的误识别率和删除困难

布隆过滤器只是挡在一台机器前面的快速查询的缓存，真正要确定一个元素一定存在的话，必须再访问这个机器里面的一个完整的数据存储结构。

#### 案例
1. 比特币网络
2. 分布式系统（Map-Reduce） —  Hadoop、search engine
3. Redis缓存
4. 垃圾邮件、评论等的过滤

#### Cache缓存
1. 记忆
2. 钱包 - 储物柜
3. 代码模块

CPU Socket 三级缓存

#### LRU Cache （Least Recently Used，最近最少使用）
* 两个要素：大小、替换策略
* HashTable + Double LinkedList
* O(1)查询 O(1)修改、更新

#### 替换策略
* LFU - least frequently used
* LRU - least recently used

内存替换算法、推荐系统：根据之前的元素被使用的频次和使用的时间来预测新来的元素它是某个老元素的概率是多少。

LRU Cache — Java

    public class LRUCache {
        private Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            map = new LinkedCappedHashMap<>(capacity);
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            return map.get(key);
        }
        
        public void put(int key, int value) {
            map.put(key, value);
        }

        private static class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
            int maximumCapacity;
            
            LinkedCappedHashMap(int maximumCapacity) {
                super(16, 0.75f, true);
                this.maximumCapacity = maximumCapacity;
            }

            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maximumCapacity;
            }
        }
    } 

### 第十八课 排序算法

#### 排序算法
1. 比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序；
2. 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下限，以线性时间运行，因此也称为线性时间非比较类排序。

* 比较类排序 大部分O(n^2)
    * 交换排序
        * 冒泡排序
        * 快速排序  O(nlogn)
    * 插入排序
        * 简单插入排序
        * 希尔排序
    * 选择排序
        * 简单选择排序
        * 堆排序  O(nlogn)
    * 归并排序  O(nlogn)
        * 二路归并排序
        * 多路归并排序
* 非比较类排序 O(n)
    * 计数排序
    * 桶排序
    * 基数排序

#### 初级排序 - O(n^2)
1. 选择排序（Selection Sort）：每次找最小值，然后放到待排序数组的起始位置。
2. 插入排序（Insertion Sort）：从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
3. 冒泡排序（Bubble Sort）：嵌套循环，每次查看相邻的元素如果逆序，则交换。

### 高级排序 - O(N*LogN)
1. 快速排序（Quick Sort）：分治 | 数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对左边和右边的字数组继续快排；以达到整个序列有序。
2. 归并排序（Merge Sort）：分治 
    1. 把长度为n的输入序列分成两个长度为n/2的字序列；
    2. 对这两个字序列分别采用归并排序；
    3. 将两个排序好的字序列合并称一个最终的排序序列。
3. 堆排序（Heap Sort）：堆插入O(logN)，取最大/最小值O(1)
    1. 数组元素依次建立小顶堆；
    2. 依次取堆顶元素，并删除；

快排代码 - Java

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter：小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
    }
    // 调用方法：quickSort(a, 0, a.length - 1)

归并排序代码 - Java

    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        } 
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用System.arraycopy(a, start1, b, start2, length)
    }

总结：归并 和 快排 具有相似性，但步骤顺序相反
* 归并：先排序左右字数组，然后合并两个有序子数组；
* 快排：先调配出左右字数组，然后对于左右字数组进行排序。

堆排序代码 - C++

    void heap_sort(int a[], int len) {
        priority_queue<int, vector<int>, greater<int> > q;
        for (int i = 0; i < len; i++) {
            q.push(a[i]);
        }
        for (int i = 0; i < len; i++) {
            a[i] = q.pop();
        }
    }

堆排序代码 Java

    static void heaping(int[] array, int length, int i) {
        int left
        int largest = i; 

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    public static void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

#### 特殊排序 - O(n)
* 计数排序（Counting Sort）
计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中；然后依次把计数大于1的填充回原数组。
* 桶排序（Bucket Sort）
桶排序的工作原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
* 基数排序（Radix Sort）
基数排序是按照地位先排序，然后收集；再按照高位排序，然后再收集；以此类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。