class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int ans=Math.max(robber(nums,dp,0),robber(nums,dp,1));
        return ans;
    }
    public int robber(int[] nums,int[] dp,int i){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int rob=nums[i]+robber(nums,dp,i+2);
        int dont=robber(nums,dp,i+1);
        return dp[i]=Math.max(rob,dont);

    }
}