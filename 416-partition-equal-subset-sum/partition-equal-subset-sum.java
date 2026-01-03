class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        dp = new Boolean[n][target + 1];
        return knap(nums, n - 1, target);
    }

    private boolean knap(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index < 0 || target < 0) return false;

        if (dp[index][target] != null)
            return dp[index][target];

        boolean take = knap(nums, index - 1, target - nums[index]);
        boolean notTake = knap(nums, index - 1, target);
        return dp[index][target] = take || notTake;
    }
}
