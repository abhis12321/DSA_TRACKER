/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Integer,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }
    private Node dfs(Node curr) {
        if(curr == null) {
            return null;
        } else if(map.containsKey(curr.val)) {
            return map.get(curr.val);
        }
        map.put(curr.val , new Node(curr.val));
        for(Node neigh : curr.neighbors) {
            Node N = dfs(neigh);
            map.get(curr.val).neighbors.add(N);
        }
        return map.get(curr.val);
    }
}