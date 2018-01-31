package com.pyq.study.algorithm;

/**
 *                                            1
 *
 *
 *                    2                                            3
 *
 *            4                5                          6                        7
 *
 *      8         9                               10                     11                12
 *
 *                                                                            13
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    static TreeNode root;
    static {
        root = getBinaryTree();
    }
    TreeNode(int val){
        this.val = val;
    }

    public static TreeNode getBinaryTree(){
        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(12);
        root.right.right.left.right = new TreeNode(13);
        return root;
    }
}
