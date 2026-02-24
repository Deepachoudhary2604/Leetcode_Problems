class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        int first=solve(cost,0);
        int second=solve(cost,1);
        return Math.min(first,second);
    }
    public int solve(int[] cost,int i){
        if(i>=cost.length){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        int one=solve(cost,i+1);
        int two=solve(cost,i+2);
        return dp[i]=cost[i]+Math.min(one,two);
    }
}   