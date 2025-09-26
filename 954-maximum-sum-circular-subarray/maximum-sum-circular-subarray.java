class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int linear=kadenes(arr);
        int total=0;
        for(int i=0;i<arr.length;i++){
            total+=arr[i];
            arr[i]=arr[i]*-1;
        }
        int mid=kadenes(arr);
        int circular=total+mid;
        if(circular==0){
            return linear;
        }
        return Math.max(circular,linear);
    }
    public static int kadenes(int[] arr){
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=Math.max(arr[i],sum+arr[i]);
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}