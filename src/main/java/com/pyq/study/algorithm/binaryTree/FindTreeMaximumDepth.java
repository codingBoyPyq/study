package com.pyq.study.algorithm.binaryTree;

public class FindTreeMaximumDepth {
    /**
     *Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes
     * along the longest path from the root node
     * down to the farthest leaf node.
     */
    public static int findTreeMaximumDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = findTreeMaximumDepth(root.left);
        int rightDepth = findTreeMaximumDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getBinaryTree();
        System.out.println(findTreeMaximumDepth(root));
    }
}
