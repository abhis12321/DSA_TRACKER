class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;

        for(int m : nums) {
            sum += m;
            max = Math.max(max , m);
        }

        if(sum % 2 == 1 || max > sum / 2) {
            return false;
        }

        sum /= 2;
        boolean dp[] = new boolean[sum+1];
        dp[0] = true;

        for(int m : nums) {
            for(int j = sum; j >= m; j--) {
                if(dp[j-m]) {
                    dp[j] = true;
                }
            }
        }

        return dp[sum];
    }
}