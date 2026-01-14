class Solution {
    public int minBitFlips(int start, int goal) {
        int ans=start^goal;
        int c=0;
        while(ans>0){
            int r=ans%2;
            if(r==1){
                c++;
            }
            ans=ans/2;
        }
        return c;
    }
}