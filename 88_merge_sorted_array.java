class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int k=0;
        int[] ans=new int[m];
        while(i<m && j<n){
            if(nums1[i]>nums2[j]){
                ans[k]=nums2[j];
                j++;
                k++;
            }
            else{
                ans[k]=nums1[i];
                i++;
                k++;
            }
        }
        
        
    }
}