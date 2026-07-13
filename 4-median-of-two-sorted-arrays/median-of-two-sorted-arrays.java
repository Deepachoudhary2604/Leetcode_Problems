class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                nums[k]=nums1[i];
                k++;
                i++;
            }
            else{
                nums[k]=nums2[j];
                k++;
                j++;
            }
        }
        while(i<nums1.length){
            nums[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            nums[k]=nums2[j];
            j++;
            k++;
        }
        if(nums.length%2!=0){
            int mid=nums.length/2;
            return (double)nums[mid];
        }
        else{
            int mid1=nums.length/2-1;
            int mid2=nums.length/2;
            double ans=(nums[mid1]+nums[mid2])/2.0;
            return ans;
        }
    }
}