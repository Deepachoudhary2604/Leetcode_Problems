class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int s=0;
        for(int i=0;i<arr.length;i++){
            s+=arr[i];
        }
        if(s%2!=0){
            return false;
        }
        int sum=s/2;
        dp = new Boolean[n+1][sum+1]; 
        return solve(arr,sum,n);
    }
    public Boolean solve(int[] arr,int sum,int n){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        if(sum>=arr[n-1]){
            return dp[n][sum]=solve(arr,sum-arr[n-1],n-1) || solve(arr,sum,n-1);
        }
        return dp[n][sum]=solve(arr,sum,n-1);
        
    }
    
}
