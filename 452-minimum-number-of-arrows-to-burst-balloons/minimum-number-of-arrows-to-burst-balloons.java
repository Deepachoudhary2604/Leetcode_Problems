class Solution {
    public int findMinArrowShots(int[][] segments) {
        Arrays.sort(segments, (a, b) -> Integer.compare(a[1], b[1]));
        int c=1;
        int prevEnd=segments[0][1];
        for(int i=1;i<segments.length;i++){
            if(prevEnd<segments[i][0]){
                c++;
                prevEnd=segments[i][1];
            }
            
        }
        return c;
    }
}