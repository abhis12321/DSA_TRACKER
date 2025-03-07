// class Solution {
//     private int dp[][];
//     public int coinChange(int[] coins, int amount) {
//         this.dp = new int[coins.length][amount+1];
//         for(int row[] : dp)     Arrays.fill(row , -1);
//         int min = change(coins.length-1 , amount , coins);
//         return min == Integer.MAX_VALUE ? -1 : min;
//     }

//     private int change(int i, int total, int coins[]) {
//         if(total == 0) {
//             return 0;
//         } else if(i < 0 || total < 0) {
//             return Integer.MAX_VALUE;
//         } else if(dp[i][total] != -1) {
//             return dp[i][total];
//         }
//         int take = change(i , total-coins[i] , coins);
//         if(take != Integer.MAX_VALUE) {
//             take++;;
//         }
//         int notake = change(i-1 , total , coins);
//         return dp[i][total] = Math.min(take , notake);
//     }
// }

class Solution {
    public int coinChange(int coins[], int target) {
        int dp[] = new int[target+1];
        Arrays.fill(dp , target+1);
        dp[0] = 0;

        for(int m : coins) {
            if(m <= target) {
                dp[m] = 1;
                for(int j = m; j <= target; j++) {
                    int t = dp[m] + dp[j-m];
                    dp[j] = Math.min(dp[j] , t);
                }
            }
        }

        return dp[target] == target+1 ? -1 : dp[target];
    }
}