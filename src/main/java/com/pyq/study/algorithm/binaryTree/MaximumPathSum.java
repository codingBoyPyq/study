package com.pyq.study.algorithm.binaryTree;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *      1
 *   /     \
 *  2       3
 */
public class MaximumPathSum {
    static int maxValue;
    public static int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        maxValue = Integer.MIN_VALUE;
        maxChildTreeSum(root);
        return maxValue;
    }
    public static int maxChildTreeSum(TreeNode child) {
        if(child==null)
            return 0;
        int leftMax = Math.max(0,maxChildTreeSum(child.left));
        int rightMax = Math.max(0,maxChildTreeSum(child.right));
        maxValue = Math.max(maxValue,leftMax + rightMax + child.val);
        return Math.max(0, child.val + Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getBinaryTree();
        System.out.println(maxPathSum(root));
    }
}
