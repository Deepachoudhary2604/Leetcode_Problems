class Solution {
    public int maxArea(int[] h) {
        int l=0;
        int r=h.length-1;
        int max=0;
        while(l<r){
            int area=0;
            if(h[l]>h[r]){
                area=h[r]*(r-l);
                r--;
            }
            else{
                area=h[l]*(r-l);
                l++;
            }
            max=Math.max(max,area);
        }
        return max;
    }
}