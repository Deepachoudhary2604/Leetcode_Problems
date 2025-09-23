public class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return coin(coins,amount,0,dp);
    }
    public static int coin(int[] coins,int amount,int idx,int[][] dp){
        if(amount==0){
            return 1;
        }
        if(idx==coins.length){
            return 0;
        }
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }
        int inc=0;
        int exe=0;
        if(coins[idx]<=amount){
            inc=coin(coins,amount-coins[idx],idx,dp);
        }
        exe=coin(coins,amount,idx+1,dp);
        
        
        return dp[amount][idx]=inc+exe;

    }
}