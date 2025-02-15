class Node {
    int key , val;
    Node next, prev;
    Node(int key , int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node head;
    Node tail;
    int current;
    int capacity;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        head = null;
        tail = null;
        current = 0;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        } else {
            Node N = map.get(key);
            removeNode(N);
            addNewNode(key , N.val);
            // printList(head);
            return N.val;
        }        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            removeNode(map.get(key));            
        }
        addNewNode(key , value);
        if(current > capacity) {
            removeNode(tail);
        }
        // printList(head);
    }

    private void addNewNode(int key, int val) {
        Node N = new Node(key , val);
        if(head == null || tail == null) {
            head = N;
            tail = N;
        } else {
            head.prev = N;
            N.next = head;
            head = N;
        }
        map.put(key , N);
        current++;
    }

    private void removeNode(Node N) {
        if(N == null) {
            return ;
        } else if(head == N) {
            head = head.next;
        } else if(N == tail) {
            tail = tail.prev;
        }

        Node prev = N.prev;
        Node next = N.next;
        if(prev != null) {
            prev.next = next;
        } 
        if(next != null) {
            next.prev = prev;
        }
        if(head == null || tail == null) {
            head = tail = null;
        }
        map.remove(N.key);
        current--;
    }

    // private void printList(Node head) {
    //     while(head != null) {
    //         System.out.print("(" + head.key + "," + head.val + ") ");
    //         head = head.next;
    //     }
    //         System.out.println(map + " " + current);
    // }
}




/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */