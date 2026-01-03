class Solution {
    public int lengthOfLIS(int[] arr) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,1);
        for(int i=0;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    int lis=dp[j];
                    dp[i]=Math.max(lis+1,dp[i]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            max=Math.max(dp[i],max);
        }
        return max;
    }
}