package com.learn.scaler.advance.tree;

public class IdenticalTreeWithSwap {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(5);
        System.out.println(solve(root, root2));
    }

    public static int solve(TreeNode A, TreeNode B) {
        int ans = 0;
        if (check(A.left, B.left)) {
            int temp = 0;
            if (A.left != null) {
                temp = solve(A.left, B.left);
            }
            if (temp == -1)
                return -1;
            ans += temp;

            temp = 0;
            if (A.right != null) {
                temp = solve(A.right, B.right);
            }
            if (temp == -1)
                return -1;
            ans += temp;
        }

        else if (check(A.left, B.right) && check(A.right, B.left)) {
            ans++;
            int temp = 0;
            if (A.left != null) {
                temp = solve(A.left, B.right);
            }
            if (temp == -1)
                return -1;
            ans += temp;

            temp = 0;
            if (A.right != null) {
                temp = solve(A.right, B.left);
            }
            if (temp == -1)
                return -1;
            ans += temp;
        } else
            return -1;
        return ans;
    }

    public static boolean check(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A == null || B == null)
            return false;
        if (A.val == B.val)
            return true;

        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
