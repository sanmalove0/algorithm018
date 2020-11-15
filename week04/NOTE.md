学习笔记

### 第九课 深度优先搜索和广度优先搜索

DFS 深度优先遍历 -> 栈
BFS 广度优先遍历 -> 队列

DFS 代码 - 递归写法

    visited = set()
    def dfs(node, visited):
        if node in visited: # terminator
            # already visited
            return
        visited.add(node)
        # process current node here.
        ...
        for next_node in node.children():
            if not next_node in visited:
                dfs(next_node, visited)

DFS 代码 - 非递归写法

    def DFS(self, tree):
        if tree.root is None:
            return []
        visited, stack = [], [tree.root]
        while stack:
            node = stack.pop()
            visited.add(node)
            process(node)
            nodes = generated_related_nodes(node)
            stack.push(nodes)

        # other processing work
        ...

BFS 代码

    def BFS(graph, start, end):
        queue = []
        queue.append([start])
        visited.add(start)
        while queue:
            node = queue.popleft()
            visited.add(node)
            process(node)
            nodes = generate_related_nodes(node)
            queue.push(nodes)
        # other processing work
        ...
    
### 第十课 贪心算法

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。
动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心法可以解决一些最优问题，如：求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。

一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好方法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。

适用贪心算法的场景：
简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

### 第十一课 二分查找

二分查找的前提：
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

代码模板

    left, right = 0, len(array) -1
    while left <= right:
        mid = (left + right) / 2
        if array[mid] == target:
            # find the target!!
            break or return result
        elif array[mid] < target:
            left = mid + 1
        else
            right = mid - 1

牛顿迭代法

#### 课后作业

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

