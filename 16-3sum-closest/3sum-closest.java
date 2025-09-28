class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=0;
        int sum=0;
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    sum=nums[i]+nums[j]+nums[k];
                    int d=Math.min(Math.abs(target-sum),diff);
                    if(d<diff){
                        diff=d;
                        ans=sum;
                    }
                }
            }
        }
        return ans;
    }
}