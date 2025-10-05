class Solution {
    public int rob(int[] nums) {
        return robber(nums);
    }
    public int robber(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int rob=nums[i]+dp[i-2];
            int dont=dp[i-1];
            dp[i]=Math.max(rob,dont);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}