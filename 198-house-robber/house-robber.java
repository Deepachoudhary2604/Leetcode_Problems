class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return robber(nums,0,dp);
    }
    public int robber(int[] nums,int idx,int[] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int skip=robber(nums,idx+1,dp);
        int rob=nums[idx]+robber(nums,idx+2,dp);
        return dp[idx]=Math.max(skip,rob);
        
    }
}