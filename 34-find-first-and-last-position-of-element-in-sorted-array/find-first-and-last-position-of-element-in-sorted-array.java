class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};

        if(nums.length==0){
            return ans;
        }
        if(nums.length==1 && nums[0]==target){
            ans[0]=0;
            ans[1]=0;
            return ans;
        }
        ans[0]=BS(nums,target,true);
        ans[1]=BS(nums,target,false);
        return ans;
    }
    public static int BS(int[] nums,int target,boolean first){
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