import java.util.*;

public class BuildTree {
    /**
     * 题号名称：105. 从前序与中序遍历序列构造二叉树
     * 题目链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * 算法思路：递归
     * 1.前序遍历中的第一个节点就是根节点，拿到根节点的值；
     * 2.在中序遍历中定位根节点的位置，得到左子树中的节点个数；
     * 3.初始化根节点；
     * 4.递归地构造左子树，根据左子树中节点个数分别确定在preorder和inorder中的范围；
     * 5.同理，递归地构造柚子树；
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildHelper(preorder, 0, n, inorder, 0, n, map);
    }
    public TreeNode buildHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, Map<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }
        int p_root = preorder[p_start];
        int i_root_idx = map.get(p_root);
        int leftNum = i_root_idx - i_start;
        TreeNode root = new TreeNode(p_root);
        root.left = buildHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_idx, map);
        root.right = buildHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_idx + 1, i_end, map);
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

