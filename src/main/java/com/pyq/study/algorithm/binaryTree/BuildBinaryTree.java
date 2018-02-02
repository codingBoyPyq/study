package com.pyq.study.algorithm.binaryTree;

import java.util.Arrays;

/**
 * Created by pangyueqiang on 17/8/24.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class BuildBinaryTree {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in){
        TreeNode rootNode = null;
        if(pre==null||in==null||pre.length==0||in.length==0||pre.length!=in.length)
            return rootNode;
        int pos_pre =0,pos_in= 0;
        int pre_len = pre.length;
        int in_len = in.length;
        rootNode = new TreeNode(pre[pos_pre]);
        int rootIndex=0;
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0])
                rootIndex=i;
        }
        if(rootIndex>0){
            int[] childPre = Arrays.copyOfRange(pre,pos_pre+1,rootIndex+1);
            int[] childIn = Arrays.copyOfRange(in,pos_in,rootIndex);
            rootNode.left=reConstructBinaryTree(childPre,childIn);
        }
        if(rootIndex<in.length-1){
            int[] childPre = Arrays.copyOfRange(pre,rootIndex+1,pre_len);
            int[] childIn = Arrays.copyOfRange(in,rootIndex+1,in_len);
            rootNode.right=reConstructBinaryTree(childPre,childIn);
        }
        return rootNode;
    }
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] mid = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre,mid);
    }
}
