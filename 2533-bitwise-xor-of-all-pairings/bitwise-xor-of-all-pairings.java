class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        //-----T L E------
        // int ans=0;
        // for(int i=0;i<nums1.length;i++){
        //     for(int j=0;j<nums2.length;j++){
        //         ans=ans^nums1[i]^nums2[j];
        //     }
        // }
        // return ans;

        if(nums1.length%2==0 && nums2.length%2==0){
            return 0;
        }
        if(nums1.length%2==0 && nums2.length%2!=0){
            int ans=0;
            for(int d:nums1){
                ans=ans^d;
            }
            return ans;
        }
        if(nums1.length%2!=0 && nums2.length%2==0){
            int ans=0;
            for(int d:nums2){
                ans=ans^d;
            }
            return ans;
        }
        else{
            int ans=0;
            for(int d:nums1){
                ans=ans^d;
            }
            for(int d:nums2){
                ans=ans^d;
            }
            return ans;
        }
    }
}