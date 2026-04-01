class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0);
    }
    public int helper(int[] nums,int i){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int pick=nums[i]+helper(nums,i+2);
        int not=helper(nums,i+1);
        return dp[i]=Math.max(pick,not);
    }
}