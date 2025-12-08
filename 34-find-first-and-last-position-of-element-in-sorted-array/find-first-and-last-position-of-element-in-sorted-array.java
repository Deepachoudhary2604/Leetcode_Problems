class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int f=bs(nums,target,true);
        int s=-1;
        if(f!=-1){
            s=bs(nums,target,false);
        }
        ans[0]=f;
        ans[1]=s;
        return ans;
    }
    public int bs(int[] nums,int target,boolean check){
        int s=0;
        int e=nums.length-1;
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target){
                if(check){
                    ans=mid;
                    e=mid-1;
                }
                else{
                    ans=mid;
                    s=mid+1;
                }
                
            }
            else if(target>nums[mid]){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return ans;
    }
}