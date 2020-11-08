class LowestCommonAncestor {

    /**
     * 题号名称：236. 二叉树的最近公共祖先
     * 题目链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * 算法思路：递归 + 分治
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

