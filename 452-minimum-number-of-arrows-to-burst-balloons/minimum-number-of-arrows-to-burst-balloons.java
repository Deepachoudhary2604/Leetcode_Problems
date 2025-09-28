class Solution {
    public int findMinArrowShots(int[][] segments) {
        int n=segments.length;
        Arrays.sort(segments, (a, b) -> Integer.compare(a[0], b[0]));
        int count=1;
        int[] prev=segments[0];
        for(int i=1;i<n;i++){
            int prevsp=prev[0];
            int prevep=prev[1];
            int currsp=segments[i][0];
            int currep=segments[i][1];
            if(prevep<currsp){
                count++;
                prev=segments[i];
            }
            else{
                prev[0]=Math.max(prevsp,currsp);
                prev[1]=Math.min(prevep,currep);
            }
        }
        return count;
    }
}