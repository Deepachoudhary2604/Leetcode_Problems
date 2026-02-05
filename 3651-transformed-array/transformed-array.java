class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                arr[i]=0;
            }
            else if(nums[i]>0){
                arr[i]=nums[(i+nums[i])%n];
            }
            else{
                int idx = (i + nums[i]) % n;

                if(idx < 0){
                    idx += n;   
                }
                arr[i] = nums[idx];
            }
        }
        return arr;
    }
}