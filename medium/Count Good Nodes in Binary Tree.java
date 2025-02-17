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
    int noOfGoodNodes;
    public int goodNodes(TreeNode root) {
        noOfGoodNodes = 0;
        findGoodNodes(root , Integer.MIN_VALUE);
        return noOfGoodNodes;
    }

    private void findGoodNodes(TreeNode root, int max) {
        if(root == null) {
            return ;
        } else if(root.val >= max) {
            noOfGoodNodes++;
        }

        // max = Math.max(max , root.val);
        findGoodNodes(root.left, Math.max(max , root.val));
        findGoodNodes(root.right, Math.max(max , root.val));
    }
}