class Solution {
    int[] dp;
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,0);
    }
    public int helper(int n,int i){
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int one=helper(n,i+1);
        int two=helper(n,i+2);
        return dp[i]=one+two;
    }
}