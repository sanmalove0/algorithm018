import java.util.*;

class Preorder {
    /**
     * 题号名称：589. N叉树的前序遍历
     * 题目链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
     * 算法思路：
     * （1）递归
     *  思路：根/遍历子节点
     *  时间复杂度：O(N)
     *  空间复杂度：O(N)
     * （2）迭代+栈+list倒序遍历
     *  思路：根入栈，循环以下步骤：栈非空时，取出栈顶元素，添加到list，将子节点倒序入栈
     *  时间复杂度：O(N)
     *  空间复杂度：O(N)
     */
    public List<Integer> preorder(Node root) {
        // 递归
        /*
        List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            list.add(root.val);               // 根
            for (Node node: root.children) {  // 遍历子节点
                list.addAll(preorder(node));
            }
        }
        return list;
        */
        // 迭代+栈+list倒序遍历       
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while(!stack.empty()) {
                Node node = stack.pop();
                list.add(node.val);
                if (node.children != null) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                    }
                }
            }
        }
        return list;
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
