class Solution {
    int[][] dp;
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        
        dp=new int[n+1][target+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,target,n);
    }
    public int solve(int[] nums,int target,int n){
        if(target==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        if(target>=nums[n-1]){
            int pick=solve(nums,target-nums[n-1],nums.length);
            int not=solve(nums,target,n-1);
            return dp[n][target]=pick+not;
        }
        return dp[n][target]=solve(nums,target,n-1);
    }
}