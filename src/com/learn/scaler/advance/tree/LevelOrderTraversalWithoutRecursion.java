package com.learn.scaler.advance.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalWithoutRecursion {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        traverseTree(root);
    }

    public static void traverseTree(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }else{
                System.out.println(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        
    }
}
