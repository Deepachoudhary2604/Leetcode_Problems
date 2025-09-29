class Solution {
    public int maximumWealth(int[][] a) {
        int ans=0;
        for(int i=0;i<a.length;i++){
            int sum=0;
            for(int j=0;j<a[i].length;j++){
                sum+=a[i][j];
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }

}