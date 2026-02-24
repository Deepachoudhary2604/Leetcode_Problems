class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(arr,n,k,0);
    }
    public int solve(int[] arr,int n,int k,int i){
        if(i==n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int maxElement = 0;
        int best = 0;
        
        // Try all partition sizes from 1 to k
        for (int len = 1; len <= k && i + len <= n; len++) {
            
            // Update max in current partition
            maxElement = Math.max(maxElement, arr[i + len - 1]);
            
            // Current partition contribution + remaining
            int currentSum = maxElement * len + solve(arr,n,k,i+len);
            
            best = Math.max(best, currentSum);
        }
        
        
        return dp[i]=best;
    }
}