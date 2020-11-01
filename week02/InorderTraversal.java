import java.util.*;

class InorderTraversal {
    /**
     * 题号名称：94. 二叉树的中序遍历
     * 题目链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * 算法思路：
     * （1）递归
     *  思路：左/根/右
     *  时间复杂度：O(N)
     *  空间复杂度：O(N)
     * （2）迭代+栈+访问标记
     *  思路：根入栈，循环以下步骤：栈非空时，取出栈顶元素，如果它是叶子节点或者有访问标记，添加到list；
     *  否则，如果它的右孩子非空，右孩子入栈；当前节点再次入栈，访问标记置true；如果它的左孩子非空，左孩子入栈。
     *  时间复杂度：O(N)
     *  空间复杂度：O(N)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归
        /*
        List<Integer> list = new ArrayList<>();
        if (root != null) {  // 递归结束条件
            list.addAll(inorderTraversal(root.left));  // 左
            list.add(root.val);                        // 根
            list.addAll(inorderTraversal(root.right)); // 右
        }
        return list;
        */
        // 迭代
        List<Integer> list = new ArrayList<>();
        Stack<Map<TreeNode, Boolean>> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        Map<TreeNode, Boolean> map = new HashMap<>(); // key为TreeNode，value为访问标识，默认为false
        map.put(root, false); // 根入栈
        stack.push(map);
        while (!stack.empty()) {
            Map<TreeNode, Boolean> tmp = stack.pop(); // 拿到栈顶元素
            TreeNode tmpNode = (TreeNode)tmp.keySet().toArray()[0];
            if ((tmpNode.left == null && tmpNode.right == null) || tmp.get(tmpNode) == true) { // 叶子节点或者访问标识为true时，添加到list
                list.add(tmpNode.val);
                continue;
            } else {
                if (tmpNode.right != null) { // 右孩子入栈
                    map = new HashMap<>();
                    map.put(tmpNode.right, false);
                    stack.push(map);
                }
                map = new HashMap<>();
                map.put(tmpNode, true); // 当前节点访问标识置true，再次入栈
                stack.push(map);
                if (tmpNode.left != null) { // 左孩子入栈
                    map = new HashMap<>();
                    map.put(tmpNode.left, false);
                    stack.push(map);
                }
            }
        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

