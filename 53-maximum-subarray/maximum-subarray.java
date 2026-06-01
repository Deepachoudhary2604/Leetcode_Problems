class Solution {
    public int maxSubArray(int[] arr) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum=Math.max(sum+arr[i],arr[i]);
            max=Math.max(sum,max);
        }
        return max;
    }

}