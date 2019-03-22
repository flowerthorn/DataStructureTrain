package com.lhx.java.algorithm.tree;

import java.util.Arrays;

/**
 * Created by lihongxin on 2019/2/27
 * 已知前序和中序遍历 重建二叉树
 */
public class RecontructBinaryTree {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    public TreeNode reConstructBinaryTree(int[] pre,int preStart,int preEnd,int[] in ,int inStart,int inEnd){
        if(preEnd<0||inEnd<0) return null;
        TreeNode root=new TreeNode(pre[preStart]);
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==pre[preStart]){
                root.left=reConstructBinaryTree(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right=reConstructBinaryTree(pre,i-inStart+preStart+1,preEnd,in,i+1,inEnd);
                break;
            }
        }
        return root;

    }

    public static void main(String[] args) {
        RecontructBinaryTree recontructBinaryTree=new RecontructBinaryTree();
        recontructBinaryTree.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
    }
}

