class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length];
        Arrays.fill(dp,-1);
        int one=helper(cost,0);
        int two=helper(cost,1);
        return Math.min(one,two);
    }
    public int helper(int[] cost,int i){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int f=cost[i]+helper(cost,i+1);
        int s=cost[i]+helper(cost,i+2);
        return dp[i]=Math.min(f,s);
    }
}