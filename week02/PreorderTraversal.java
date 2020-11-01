import java.util.*;

class PreorderTraversal {
    /**
     * 题号名称：144. 二叉树的前序遍历
     * 题目链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     * 算法思路：
     * （1）递归
     *  思路：根/左/右
     *  时间复杂度：O(N)
     *  空间复杂度：O(N)
     * （2）迭代+栈
     *  思路：根入栈，循环以下步骤：栈非空时，取出栈顶元素，添加到list；
     *  如果它的右孩子非空，右孩子入栈；如果它的左孩子非空，左孩子入栈。
     *  时间复杂度：O(N)
     *  空间复杂度：O(N)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归
        /*
        List<Integer> list = new ArrayList<>();
        if (root == null) { // 递归结束条件
            return list;
        }
        list.add(root.val);                         // 根
        list.addAll(preorderTraversal(root.left));  // 左
        list.addAll(preorderTraversal(root.right)); // 右
        return list;
        */
        // 迭代
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); // 根入栈
        while (!stack.empty()) {
            TreeNode tmp = stack.pop(); // 取出栈顶元素，加入list
            list.add(tmp.val);
            if (tmp.right != null) {  // 右孩子入栈
                stack.push(tmp.right);
            }
            if (tmp.left != null) {  // 左孩子入栈
                stack.push(tmp.left);
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

