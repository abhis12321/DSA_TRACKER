class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            String odd = getPalindromeWithMidPoints(i, i, s);
            String even = getPalindromeWithMidPoints(i,i+1, s);
            String currMax = odd.length() > even.length() ? odd : even;
            ans = currMax.length() > ans.length() ? currMax : ans;
        }
        return ans;
    }

    private String getPalindromeWithMidPoints(int start, int end, String s) {
        while(start >= 0 && end < s.length()) {
            if(s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        }
        return s.substring(start + 1 , end);
    }
}