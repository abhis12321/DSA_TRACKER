/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        } else if(p.val > q.val) {
            return lowestCommonAncestor(root , q , p);
        } else if(root == p || root == q) {
            return root;
        } else if(p.val < root.val && q.val > root.val) {
            return root;
        } else if(p.val < root.val) {
            return lowestCommonAncestor(root.left , p , q);
        } else {
            return lowestCommonAncestor(root.right , q , p);
        }

        // TreeNode left = lowestCommonAncestor(root.left , p , q);
        // TreeNode right = lowestCommonAncestor(root.right , p , q);
        
        // return (left != null && right !=  null) ? root : left == null ? right : left;
    }
}