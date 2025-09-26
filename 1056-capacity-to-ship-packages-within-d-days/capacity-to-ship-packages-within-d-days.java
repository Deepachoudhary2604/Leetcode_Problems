class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int min=0;
        for(int i=0;i<weights.length;i++){
            max+=weights[i];
            min=Math.max(weights[i],min);
        }
        int ans=BS(weights,min,max,days);
        return ans;
    }
    public static int BS(int[] weights,int s,int e,int days){
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            int d=1;
            int w=0;
            for(int i=0;i<weights.length;i++){
                if((weights[i]+w)>mid){
                    d++;
                    w=0;
                }
                w=w+weights[i];
            }
            if(d>days){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return s;
        
    }
}