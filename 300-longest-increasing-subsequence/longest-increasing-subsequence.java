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
                    int val=dp[j];
                    dp[i]=Math.max(dp[i],val+1);
                }
            }
        }
        int max=dp[0];
        for(int num:dp){
            max=Math.max(num,max);
        }
        return max;
    }
}