class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int val=0;
            for(int j=i;j<nums.length;j++){
                
                val=val | nums[j];
                if(val>=k){
                    ans=Math.min(j-i+1,ans);
                }
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}