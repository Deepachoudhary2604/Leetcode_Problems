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
            if(canEat(piles,mid,h)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
    public static boolean canEat(int[] piles,int mid,int h){
        long hour=0;
        for(int p:piles){
            hour+=p/mid;
            if(p%mid!=0){
                hour++;
            }
        }
        return hour<=h;
    }
}