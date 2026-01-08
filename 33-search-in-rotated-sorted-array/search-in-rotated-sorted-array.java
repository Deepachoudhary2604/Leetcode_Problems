class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }
            else{
                return -1;
            }
        }
        int p=pivot(nums,0,nums.length-1);
        if(p==-1){
            return BS(nums,0,nums.length-1,target);
        }
        int ans=BS(nums,0,p,target);
        if(ans!=-1){
            return ans;
        }
        return BS(nums,p+1,nums.length-1,target);
    }
    public int pivot(int[] nums,int s,int e){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid<e && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid>s && nums[mid-1]>nums[mid]){
                return mid-1;
            }
            if(nums[mid]>=nums[s]){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return -1;
    }
    public int BS(int[] nums,int s,int e,int target){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                e=mid-1;
            }
            else{
                s=mid+1;
            }

        }
        return -1;
    }
}