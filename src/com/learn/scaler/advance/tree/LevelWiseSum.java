package com.learn.scaler.advance.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelWiseSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        printSumLevelWise(root);
    }

    public static void printSumLevelWise(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int levelNumber = 1;
        int levelSum = 0;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                System.out.println(levelNumber+" level sum is:"+levelSum);
                if(!queue.isEmpty()){
                    levelSum = 0;
                    queue.add(null);
                    levelNumber++;
                }
            }else{
                levelSum = levelSum + temp.val;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }   
        }
    }
}
