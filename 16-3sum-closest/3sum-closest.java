class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=0;
        int d=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    int diff=Math.abs(sum-target);
                    if(d>diff){
                        d=diff;
                        ans=sum;
                    }
                }
            }
        }
        return ans;
    }
}