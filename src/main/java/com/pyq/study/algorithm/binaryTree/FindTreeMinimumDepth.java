package com.pyq.study.algorithm.binaryTree;

public class FindTreeMinimumDepth {
    /**
     * Given a binary tree, find its minimum depth.
     * The minimum depth is the number of nodes along the shortest path
     * from the root node down to the nearest leaf node.
     */
    public static int findTreeMinimumDepth(TreeNode root){
        if(root==null)
            return 0;
        if(root.left == null)
            return findTreeMinimumDepth(root.right) + 1;
        if(root.right == null)
            return findTreeMinimumDepth(root.left) + 1;
        int leftDepth = findTreeMinimumDepth(root.left);
        int rightDepth = findTreeMinimumDepth(root.right);
        return leftDepth < rightDepth ? leftDepth +1 : rightDepth +1;
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.getBinaryTree();
        System.out.println(findTreeMinimumDepth(root));
    }
}
