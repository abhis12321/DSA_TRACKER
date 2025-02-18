class Node {
    boolean isEnd;
    Node child[];
    Node() {
        child = new Node[26];
        isEnd = false;
    }
}

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node T = root;
        for(char c : word.toCharArray()) {
            if(T.child[c - 'a'] == null) {
                T.child[c - 'a'] = new Node();
            }
            T = T.child[c - 'a'];
        }
        T.isEnd = true;
    }
    
    public boolean search(String word) {
        return check(0 , word.toCharArray() , root);
    }

    private boolean check(int i, char word[] , Node root) {
        // if(root == null || i >= word.length) {
        //     return false;
        // } else if(i == word.length - 1) {
        //     if(word[i] == '.') {
        //         for(Node N : root.child) {
        //             if(N != null && N.isEnd) {
        //                 return true;
        //             }
        //         }
        //     } else if(root.child[word[i] - 'a'] != null && root.child[word[i] - 'a'].isEnd) {
        //         return true;
        //     } else {
        //         return false;
        //     }
        // }
        if(i >= word.length) {
            if(root == null || !root.isEnd) {
                return false;
            } else {
                return true;
            }
        } else if(root == null) {
            return false;
        } 

        if(word[i] == '.') {
            for(Node N : root.child) {
                if(check(i+1 , word , N)) {
                    return true;
                }
            }
        } else {
            return check(i+1 , word , root.child[word[i] - 'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */