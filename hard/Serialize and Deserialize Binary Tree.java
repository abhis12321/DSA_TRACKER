/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private int index;
    private StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        preorder(root);
        return sb.toString();
    }

    private void preorder(TreeNode root) {
        if(root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        return dfs(data.split(" "));
    }

    private TreeNode dfs(String data[]) {
        if(index >= data.length || "#".equals(data[index])) {
            index++;
            return null;
        }
        TreeNode N = new TreeNode(Integer.parseInt(data[index++]));
        N.left = dfs(data);
        N.right = dfs(data);
        return N;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));