class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s=0;
        int e=0;
        for(int i=0;i<weights.length;i++){
            s=Math.max(weights[i],s);
            e+=weights[i];
        }
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            int load=0;
            int day=1;
            for(int i=0;i<weights.length;i++){
                load+=weights[i];
                if(load>mid){
                    load=weights[i];
                    day++;
                }
            }
            if(day<=days){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}