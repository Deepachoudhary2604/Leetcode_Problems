class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int total=0;
        int n=nums.length;
        for(int i:nums){
            total+=i;
        }
        if(total%2!=0){
            return false;
        }
        int sum=total/2;
        dp=new Boolean[n+1][sum+1];
        return part(nums,n,sum);
    }
    public boolean part(int[] nums,int n,int sum){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        if(nums[n-1]>sum){
            return dp[n][sum]=part(nums,n-1,sum);
        }
        return dp[n][sum]=part(nums,n-1,sum-nums[n-1]) || part(nums,n-1,sum);
    }
}