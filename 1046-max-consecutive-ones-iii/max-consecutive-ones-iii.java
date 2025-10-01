class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int size=0;
        int c=0;
        int r=0;
        while(r<nums.length){
            if(nums[r]==0){
               c++;
            }
            if(c>k){
                if(nums[l]==0){
                    c--;
                }
                l++;
            }
            size=Math.max(size,r-l+1);
            r++;
        }
        return size;
    }
}