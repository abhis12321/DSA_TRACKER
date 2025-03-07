class Solution {
    private int N , dp[];
    private final Map<String,String> map = new HashMap<>();
    {
        for(int i = 1; i <= 26; i++) {
            char c = (char)('a' + i - 1);
            String key = i+"";
            String value = c + "";
            map.put(key , value);
        }
    }
    public int numDecodings(String s) {
        this.N = s.length();
        this.dp = new int[N];
        Arrays.fill(dp , -1);
        return decode(0 , s);
    }

    private int decode(int i, String s) {
        // System.out.println(i);
        if(i >= this.N) {
            return 1;
        } else if(dp[i] != -1) {
            return dp[i];
        }

        int decodes = 0;
        String key1 = s.substring(i,i+1);
        if(map.containsKey(key1)) {
            decodes += decode(i+1 , s);
        }
        if(i < this.N - 1) {
            String key2 = s.substring(i,i+2);
            if(map.containsKey(key2) && !key1.equals(key2)) {
                decodes += decode(i+2 , s);
            }
        }
        // System.out.println(key1 + " " + key2 + " " + s);
        return dp[i] = decodes;
    }
}