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
    public int maxAncestorDiff(TreeNode root) {
        return find(root)[2];
    }
    private int[] find(TreeNode root) {
        if(root == null) {
            return new int[]{Integer.MAX_VALUE/4 , Integer.MIN_VALUE/4 , 0}; // min , max , maxgap
        }

        int left[] = find(root.left);
        int right[] = find(root.right);

        int val_01 = root.val - left[0];
        int val_02 = left[1] - root.val;
        int val_03 = left[2];
        int gap1 = Math.max(val_01 , Math.max(val_02 , val_03));

        int val_11 = root.val - right[0];
        int val_12 = right[1] - root.val;
        int val_13 = right[2];
        int gap2 = Math.max(val_11 , Math.max(val_12 , val_13));

        int min = Math.min(root.val , Math.min(left[0] , right[0]));
        int max = Math.max(root.val , Math.max(left[1] , right[1]));
        
        return new int[]{min , max , Math.max(gap1 , gap2)};
    }
}