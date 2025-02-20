class Solution {
    List<List<String>> A;
    public List<List<String>> partition(String s) {
        A = new ArrayList<>();
        find(0 , s , new ArrayList<>());
        return A;
    }
    private void find(int currIndex, String s, List<String> B) {
        if(currIndex >= s.length()) {
            A.add(new ArrayList<>(B));
            return ;
        }

        for(int end = currIndex; end < s.length(); end++) {
            if(isPalindrome(s , currIndex , end)) {
                B.add(s.substring(currIndex , end+1));
                find(end+1 , s , B);
                B.remove(B.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}