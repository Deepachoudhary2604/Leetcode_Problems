class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        if(n==1){
            return true;
        }
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        int p1=solve(0,n-1,nums);
        int p2=total-p1;
        if(p1>=p2){
            return true;
        }
        else{
            return false;
        }
    }
    public int solve(int i,int j,int[] nums){
        if(i>j){
            return 0;
        }
        if(i==j){
            return nums[i];
        }
        int take_i=nums[i]+Math.min((solve(i+2,j,nums)),solve(i+1,j-1,nums));
        int take_j=nums[j]+Math.min((solve(i+1,j-1,nums)),solve(i,j-2,nums));
        return Math.max(take_i,take_j);
    }
}