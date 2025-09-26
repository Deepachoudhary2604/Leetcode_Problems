class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int min=0;
        for(int i=0;i<weights.length;i++){
            max+=weights[i];
            min=Math.max(weights[i],min);
        }
        int s=min;
        int e=max;
        while(s<=e){
            int mid=s+(e-s)/2;
            int currWeight=0;
            int currdays=1;
            for(int i=0;i<weights.length;i++){
                if(currWeight+weights[i]>mid){
                    currdays++;
                    currWeight=0;
                }
                currWeight+=weights[i];
            }
            if(currdays>days){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return s;
    }
}