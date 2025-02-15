/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) {
            map.put(null , null);
            return null;
        }
        Node N = new Node(head.val);
        map.put(head , N);
        N.next = copyRandomList(head.next);
        N.random = map.get(head.random);
        return N;
    }
}