class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n){
            return -1;
        }
        int ans=-1;
        int s=Integer.MAX_VALUE;
        int e=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            s=Math.min(s,bloomDay[i]);
            e=Math.max(e,bloomDay[i]);
        }
        while(s<=e){
            int mid=s+(e-s)/2;
            if(canBloom(bloomDay,mid,m,k)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
    public boolean canBloom(int[] arr,int mid,int m,int k){
        int flowerbloom=0;
        int bucket=0;
        for(int val:arr){
            if(val<=mid){
                flowerbloom++;
                if(flowerbloom==k){
                    bucket++;
                    flowerbloom=0;
                }
                
            }
            else{
                flowerbloom=0;
            }
        }
        return bucket>=m;
    }
}