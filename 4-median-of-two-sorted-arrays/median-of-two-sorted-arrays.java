class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                ans[k]=nums1[i];
                i++;
                k++;
            }
            else{
                ans[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<nums1.length){
            ans[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            ans[k]=nums2[j];
            j++;
            k++;
        }
        if(k%2!=0){
            int mid=k/2;
            return ans[mid]/1.0;
            
        }
        int mid1=k/2;
        int mid2=k/2-1;
        return (ans[mid1]+ans[mid2])/2.0;

    }
}