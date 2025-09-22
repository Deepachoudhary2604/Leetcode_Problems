class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }
    public static int LIS(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<dp.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    int l=dp[j];
                    dp[i]=Math.max(l+1,dp[i]);
                }
            }
        }
        int max=dp[0];
        for(int i=0;i<dp.length;i++){
            max=Math.max(dp[i],max);
        }
        return max;
    }
}