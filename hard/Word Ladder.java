class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> H = new HashSet<>();
        Map<String,Set<String>> map = new HashMap<>();

        for(String s : wordList) {
            H.add(s);
            map.put(s , new HashSet<>());
        }

        // System.out.println(H);
        for(String s : H) {
            addAllNodes(s , H , map);
        }
        if(!map.containsKey(beginWord)) {
            map.put(beginWord , new HashSet<>());
            addAllNodes(beginWord , H , map);
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 0;
        H.clear();

        while(!q.isEmpty()) {
            level++;
            int size = q.size();
            while(size-- > 0) {
                String curr = q.poll();
                if(curr.equals(endWord)) {
                    return level;
                }

                for(String neighbor : map.get(curr)) {
                    if(H.add(neighbor)) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        // for(String key : map.keySet()) {
        //     System.out.println(key + " " + map.get(key));
        // }

        return 0;
    }
    private final String alphabets = "abcdefghijklmnopqrstuvwxyz"; 
    private void addAllNodes(String s, Set<String> H, Map<String,Set<String>> map) {
        int N = s.length();
        Set<String> nodes = map.getOrDefault(s , new HashSet<>());
        for(int i = 0; i < N; i++) {
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            for(char c : alphabets.toCharArray()) {
                String nvNode = left + c + right;
                // System.out.print(nvNode + " ");
                if(H.contains(nvNode) && c != s.charAt(i)) {
                    nodes.add(nvNode);
                }
            }
        }
        // System.out.println(nodes + " <- " + s);
        map.put(s , nodes);
    }
}