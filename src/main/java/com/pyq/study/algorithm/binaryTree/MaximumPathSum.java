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
    public static int maxSum = 0x80000000;
    public static int greatSum = 0x80000000;

    public static int maxPathSum(TreeNode root) {
         if(root==null)
             return 0;
         if(root.left==null)
             return maxChildTreeSum(root.right) + root.val;
         else if(root.right==null)
             return maxChildTreeSum(root.left) + root.val;
         else {
             return  maxChildTreeSum(root.left) + root.val + maxChildTreeSum(root.right);
         }
    }
    public static int maxChildTreeSum(TreeNode child) {
        if(child.left==null)
            return 0;
        if(child.left==null)
            return maxChildTreeSum(child.right) + child.val;
        else if(child.right==null)
            return maxChildTreeSum(child.left) + child.val;
        else {
            int maxLeftTree =  maxChildTreeSum(child.left);
            int maxRightTree =  maxChildTreeSum(child.right);
            return  maxLeftTree > maxRightTree ? maxLeftTree + child.val : maxRightTree + child.val;
        }
    }

    public static void main(String[] args) {
        //TreeNode root = TreeNode.getBinaryTree();
        //System.out.println(maxPathSum(root));
        System.out.println(0x80000000);
    }
}
