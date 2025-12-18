class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        int first=bs(nums,target,true);
        int second=-1;
        if(first!=-1){
            second=bs(nums,target,false);
        }
        ans[0]=first;
        ans[1]=second;
        return ans;
    }
    public int bs(int[] nums,int target,boolean first){
        int ans=-1;
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target){
                ans=mid;
                if(first){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
            else if(nums[mid]>target){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}