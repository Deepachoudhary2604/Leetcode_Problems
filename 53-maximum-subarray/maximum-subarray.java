class Solution {
    public int maxSubArray(int[] arr) {
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int sum=arr[0];
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i]=Math.max(arr[i],arr[i]+dp[i-1]);
            sum=Math.max(sum,dp[i]);
        }
        return sum;
    }

}