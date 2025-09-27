class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length+nums2.length];
        int k=0;
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){
                arr[k]=nums2[j];
                j++;
                k++;
            }
            else{
                arr[k]=nums1[i];
                i++;
                k++;
            }
        }
        while(i<nums1.length){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            arr[k]=nums2[j];
            j++;
            k++;
        }
        int n = arr.length;
        if (n % 2 == 1) {
            return arr[n / 2];
        } else {
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            return (arr[mid1] + arr[mid2]) / 2.0;
        }
    }
}