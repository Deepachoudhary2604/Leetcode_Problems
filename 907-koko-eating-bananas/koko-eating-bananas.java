class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max=0;
        for(int i=0;i<piles.length;i++){
            max=Math.max(piles[i],max);
        }
        int s=min;
        int e=max;
        int ans=max;
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
        long hour = 0; // ✅ use long to avoid overflow
        for (int pile : piles) {
            hour += (pile + mid - 1) / mid;
            if (hour > h) return false; // early exit
        }
        return hour <= h;
    }
}