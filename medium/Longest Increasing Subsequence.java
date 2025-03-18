class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp , 1);
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j] , 1+dp[i]);
                    max = Math.max(max , dp[j]);
                }
            }
        }

        return max;
    }
}