class Solution {
    public int maxSubArray(int[] arr) {
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum=Math.max(arr[i],sum+arr[i]);
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}