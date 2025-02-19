class Solution {
    List<List<Integer>> A;
    public List<List<Integer>> permute(int[] nums) {
        A = new ArrayList<>();
        add(0 , nums);
        return A;
    }
    private void add(int i, int nums[]) {
        if(nums.length == i) {
            List<Integer> B = new ArrayList<>();
            for(int m : nums)  B.add(m);
            A.add(B);
            return;
        } 

        for(int j = i; j < nums.length; j++) {
            swap(i,j,nums);
            add(i+1 , nums);
            swap(i,j,nums);
        }
    }

    private void swap(int i, int j, int arr[]) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}