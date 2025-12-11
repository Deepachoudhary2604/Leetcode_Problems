class Solution {
    public int splitArray(int[] nums, int k) {
        int s=0;
        int e=0;
        for(int i=0;i<nums.length;i++){
            s=Math.max(nums[i],s);
            e+=nums[i];
        }
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            int split=1;
            int count=0;
            for(int i=0;i<nums.length;i++){
                count+=nums[i];
                if(count>mid){
                    split++;
                    count=nums[i];
                }
            }
            if(split<=k){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}