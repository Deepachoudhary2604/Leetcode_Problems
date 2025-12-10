class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=0;
        for(int i=0;i<piles.length;i++){
            e=Math.max(e,piles[i]);
        }
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(caneat(piles,mid,h)){
                e=mid-1;
                ans=mid;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
    public boolean caneat(int[] piles,int mid,int h){
        long hour=0;
        for(int pile:piles){
            hour+=(pile/mid);
            if(pile%mid!=0){
                hour++;
            }

        }
        return hour<=h;
    }
}