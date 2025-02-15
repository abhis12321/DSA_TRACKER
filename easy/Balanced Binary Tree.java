/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean isBalancedTree = true;
    public boolean isBalanced(TreeNode root) {
        checkTree(root);
        return isBalancedTree;
    }

    private int checkTree(TreeNode root) {
        if(root == null || !isBalancedTree) {
            return 0;
        }
        int left = checkTree(root.left);
        int right = checkTree(root.right);
        if(Math.abs(left - right) > 1) {
            isBalancedTree = false;
        }
        return Math.max(left , right) + 1;
    }
}