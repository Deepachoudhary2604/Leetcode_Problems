class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;

        int i = 0;

        // Step 1: strictly increasing
        while(i < n - 1 && nums[i] < nums[i + 1]) i++;
        if(i == 0) return false; // first segment must have at least 1 element
        int p = i;

        // Step 2: strictly decreasing
        while(i < n - 1 && nums[i] > nums[i + 1]) i++;
        if(i == p) return false; // second segment must have at least 1 element
        int q = i;

        // Step 3: strictly increasing (must have at least 1 element)
        if(q >= n - 1) return false; // no element left for final increase
        while(i < n - 1 && nums[i] < nums[i + 1]) i++;

        return i == n - 1;
    }
}
