class Solution {
    public int findMin(int[] nums) {
        int min_element = findMinimum(nums);
        return min_element;
    }

    public static int findMinimum(int[] nums) {
        int s=0;
        int e=nums.length-1;
        int ans=nums[0];
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid<e && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(mid>s && nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if(nums[mid]>=nums[s]){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return ans;
    }
}
