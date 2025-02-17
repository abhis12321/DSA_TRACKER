class Solution {
    Set<String> H;
    public int numTilePossibilities(String tiles) {
        H = new HashSet<>();
        count(tiles, "");
        System.out.println(H);
        return H.size();
    }

    private void count(String s, String curr) {
        if(s.length() == 0) {
            return;
        }

        for(int i = 1; i <= s.length(); i++) {
            String str = s.substring(0,i-1) + s.substring(i,s.length());
            System.out.println(str + " " + curr);
            H.add(curr + s.charAt(i-1));
            count(str , curr + s.charAt(i-1));
        }
    }
}