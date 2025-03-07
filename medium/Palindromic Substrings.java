class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count += countPalindromes(i , i , s);   // odd length palindromes
            count += countPalindromes(i , i+1 , s);   // even length palindromes
        }
        return count;
    }

    private int countPalindromes(int left, int right, String s) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}