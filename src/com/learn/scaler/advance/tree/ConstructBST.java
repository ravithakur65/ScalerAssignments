package com.learn.scaler.advance.tree;

import java.util.ArrayList;

public class ConstructBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(5);
		list.add(1);
		list.add(7);
		list.add(40);
		list.add(50);
		TreeNode root = construct(list);
		

	}
	public static TreeNode construct(ArrayList<Integer> list) {
		TreeNode tree = new TreeNode(list.get(0));
		TreeNode root = tree;
		for(Integer item : list) {
			
			if(tree.val<item) {
				tree.right = new TreeNode(item);
				root = tree.right;
			}
			else {
				tree.left = new TreeNode(item);
				root = tree.left;
			}
		}
		
		return root;
	}
	
	public static boolean search(TreeNode root, int key) {
		while(root!=null) {
			if(key == root.val)
				return true;
			else if(root.val>=key)
				root = root.left;
			else
				root = root.right;
		}
		return false;
	}
}
