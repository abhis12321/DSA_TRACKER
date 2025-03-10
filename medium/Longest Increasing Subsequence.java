class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp , 1);
        int max = 1;
        for(int i = nums.length-1; i > 0; i--) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    dp[j] = Math.max(dp[j] , 1+dp[i]);
                    max = Math.max(max , dp[j]);
                }
            }
        }

        return max;
    }
}