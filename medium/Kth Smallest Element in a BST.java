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
    private int K, ans;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        ans = -1;
        kth(root);
        return ans;
    }

    private void kth(TreeNode root) {
        if(root == null || ans != -1) {
            return;
        }
        kth(root.left);
        K--;
        if(K == 0) {
            ans = root.val;
        }
        kth(root.right);
    }
}