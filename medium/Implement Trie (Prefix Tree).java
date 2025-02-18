class Node {
    boolean isEnd;
    Node childs[];
    Node() {
        isEnd = false;
        childs = new Node[26];
    }
}


class Trie {
    Node head;
    public Trie() {
        head = new Node();
    }
    
    public void insert(String word) {
        insertAt(0 , word , head);
    }

    private void insertAt(int i, String word, Node root) {
        if(i >= word.length()) {
            root.isEnd = true;
            return;
        }
        int childIndex = word.charAt(i) - 'a';
        Node N = root.childs[childIndex];
        if(N == null) {
            N = new Node();
        }
        root.childs[childIndex] = N;
        insertAt(i+1 , word , N);
        // return N;
    }
    
    public boolean search(String word) {
        return searchAt(0 , word , head);
    }

    private boolean searchAt(int i, String word, Node root) {
        if(i >= word.length()) {
            return root.isEnd;
        }
        int childIndex = word.charAt(i) - 'a';
        Node child = root.childs[childIndex];
        if(child == null) {
            return false;
        }
        return searchAt(i+1 , word , child);
    }
    
    public boolean startsWith(String prefix) {
        return startsWithAt(0 , prefix, head);
    }

    private boolean startsWithAt(int i, String word, Node root) {
        if(i >= word.length()) {
            return true;
        }
        int childIndex = word.charAt(i) - 'a';
        Node child = root.childs[childIndex];
        if(child == null) {
            return false;
        }
        return startsWithAt(i+1 , word , child);
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */