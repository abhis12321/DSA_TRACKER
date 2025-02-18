class TrieNode {
    String word;
    TrieNode childs[];
    TrieNode() {
        word = null;
        childs = new TrieNode[26];
    }
}

class Solution {
    private TrieNode root;
    private int dirs[][] = {{-1,0} , {1,0} , {0,-1} , {0,1}};
    private List<String> A;
    private Set<String> H;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        A = new ArrayList<>();
        H = new HashSet<>();
        for(String word : words) {
            TrieNode T = root;
            for(char c : word.toCharArray()) {
                if(T.childs[c - 'a'] == null) {
                    T.childs[c - 'a'] = new TrieNode();
                }
                T = T.childs[c - 'a'];
            }
            T.word = word;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                findWords(i , j , board , root);
            }
        }
        return A;
    }

    private void findWords(int i, int j, char board[][], TrieNode root) {
        if(root == null || i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return ;
        }
        char c = board[i][j];
        TrieNode N = root.childs[c - 'a'];
        if(N == null) {
            return ;
        } else if(N.word != null && H.add(N.word)) {
            A.add(N.word);
        }
        board[i][j] = '#';
        for(int dir[] : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            findWords(row , col , board , N);
        }
        board[i][j] = c;
    }
}