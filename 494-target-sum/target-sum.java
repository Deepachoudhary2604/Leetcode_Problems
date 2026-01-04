class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] arr, int target) {
        int totalSum = 0;
        for (int x : arr) totalSum += x;

        // invalid cases
        if (Math.abs(target) > totalSum) return 0;
        if ((totalSum + target) % 2 != 0) return 0;

        int sum = (totalSum + target) / 2;
    
        int n=arr.length;
        dp = new int[n+1][sum+1]; 
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,sum,n);
    }
    public int solve(int[] arr,int sum,int n){
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        if(dp[n][sum]!=-1){
            return dp[n][sum];
        }
        if(sum>=arr[n-1]){
            return dp[n][sum]=solve(arr,sum-arr[n-1],n-1)+solve(arr,sum,n-1);
        }
        return dp[n][sum]=solve(arr,sum,n-1);
    }
}