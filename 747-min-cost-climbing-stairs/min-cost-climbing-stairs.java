class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        int zero=climb(cost,0,dp);
        int first=climb(cost,1,dp);
        return Math.min(zero,first);
    }
    public static int climb(int[] cost,int i,int[] dp){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int f=climb(cost,i+1,dp);
        int s=climb(cost,i+2,dp);
        return dp[i]=cost[i]+Math.min(f,s);
        
    }
}