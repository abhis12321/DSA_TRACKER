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
    // int noOfGoodNodes;
    public int goodNodes(TreeNode root) {
        // noOfGoodNodes = 0;
        return findGoodNodes(root , Integer.MIN_VALUE);
        // return noOfGoodNodes;
    }

    private int findGoodNodes(TreeNode root, int max) {
        if(root == null) {
            return 0;
        } 
        int noOfGoodNodes = 0;
        if(root.val >= max) {
            noOfGoodNodes++;
        }

        max = Math.max(max , root.val);
        noOfGoodNodes += findGoodNodes(root.left, max);
        noOfGoodNodes += findGoodNodes(root.right, max);
        return noOfGoodNodes;
    }
}