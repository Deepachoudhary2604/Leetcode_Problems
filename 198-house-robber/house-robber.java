class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length+1];
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
        int one=nums[i]+helper(nums,i+2);
        int two=helper(nums,i+1);
        return dp[i]=Math.max(one,two);
    }

}