class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        while(nums1[i]!=0){
            i++;
        }
        while(i<nums1.length){
            nums1[i]=nums2[j];
            i++;
            j++;
        }
        Arrays.sort(nums1);
    }
}