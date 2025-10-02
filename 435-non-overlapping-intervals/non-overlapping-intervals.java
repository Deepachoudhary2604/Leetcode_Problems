class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int prevEnd=intervals[0][1];
        int c=0;
        for(int i=1;i<intervals.length;i++){
            if(prevEnd>intervals[i][0]){
                c++;
            }
            else{
                prevEnd=intervals[i][1];
            }
        }
        return c;
    }
}