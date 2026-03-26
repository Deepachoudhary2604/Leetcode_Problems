class Solution {
    int[] dp1;
    int[] dp2;
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        dp1=new int[nums.length];
        Arrays.fill(dp1,-1);
        dp2=new int[nums.length];
        Arrays.fill(dp2,-1);
        int f=helper(nums,0,nums.length-2,dp1);
        int s=helper(nums,1,nums.length-1,dp2);
        return Math.max(f,s);
    }
    public int helper(int[] nums,int s,int e,int[] dp){
        if(s>e){
            return 0;
        }
        if(dp[s]!=-1){
            return dp[s];
        }
        int one=helper(nums,s+1,e,dp);
        int two=nums[s]+helper(nums,s+2,e,dp);
        return dp[s]=Math.max(one,two);
    }
}