class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int ans1=0;
        int ans2=0;
        for(int d:arr1){
            ans1=ans1^d;
        }
        for(int d:arr2){
            ans2=ans2^d;
        }
        return ans1 & ans2;
    }
}