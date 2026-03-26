class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
    public int helper(int n){
        if(n<=0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int one=helper(n-1);
        int two=helper(n-2);
        return dp[n]=one+two;
    }
}