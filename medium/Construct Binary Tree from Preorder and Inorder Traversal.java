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
    private int N, index;
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        N = preorder.length;
        index = 0;

        for(int i = 0; i < N; i++) {
            map.put(inorder[i] , i);
        }

        return buildTree(0 , N-1 , preorder);
    }

    private TreeNode buildTree(int left, int right, int preorder[]) {
        if(left > right) {
            return null;
        } 
        int val = preorder[index++];
        int curr = map.get(val);
        TreeNode N = new TreeNode(val);
        N.left = buildTree(left , curr-1 , preorder);
        N.right = buildTree(curr+1 , right , preorder);
        return N;
    }
}