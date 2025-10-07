class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(i<j){
            sum=nums[i]+nums[j];
            max=Math.max(max,sum);
            i++;
            j--;
        }
        return max;
    }
}