class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            boolean isValid = checkPartition(i*i , 0 , i);
            if(isValid) {
                ans += i * i;
            }
        }      
        return ans;
    }

    private boolean checkPartition(int curr, int sum, int n) {
        if(curr == 0) {
            if(sum == n) {
                return true;
            } else {
                return false;
            }
        } else if(sum > n) {
            return false;
        }

        int div = 10;
        while(div <= curr*10) {
            int v1 = curr / div;
            int v2 = curr % div;
            if(checkPartition(v1 , sum+v2 , n)) {
                return true;
            }
            div *= 10;
        }
        return false;
    }
}