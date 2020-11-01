import java.util.*;

class LevelOrder {
    /**
     * 题号名称：429. N叉树的层序遍历
     * 题目链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
     * 算法思路：BFS（广度优先遍历）
     * 时间复杂度：O(N) N为节点总个数
     * 空间复杂度：O(N)
     */
    public List<List<Integer>> levelOrder(Node root) {

        // BFS
        List<List<Integer>> result = new ArrayList<>();
        List<Node> l1 = new ArrayList<>();
        List<Node> l2 = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        l1.add(root);
        while (!l1.isEmpty()) {
            result.add(list);  // 添加上一层节点值的list到result
            list = new ArrayList<>();
            l2 = new ArrayList<>();
            for (Node node: l1) {  // 遍历该层节点
                for (Node child: node.children) {  // 将每个节点的子节点加入list
                    list.add(child.val);
                    l2.add(child);
                }
            }
            l1 = l2;
        }
        return result;
    }


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

