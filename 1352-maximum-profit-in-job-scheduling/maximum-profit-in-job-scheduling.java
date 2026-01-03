class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int s=startTime.length;
        int e=endTime.length;
        int p=profit.length;
        int[][] arr=new int[s][3];
        for(int i=0;i<s;i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp,-1);
        return solve(arr,0,dp);
    }
    public int solve(int[][] arr,int i,int[] dp){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int next=getIndex(arr,i+1,arr[i][1]);
        int taken=arr[i][2]+solve(arr,next,dp);
        int notTaken=solve(arr,i+1,dp);
        return dp[i]=Math.max(taken,notTaken);
    }
    public int getIndex(int[][] arr,int l,int target){
        for(int i=l;i<arr.length;i++){
            if(arr[i][0]>=target){
                return i;
            }
        }
        return arr.length;
    }
}