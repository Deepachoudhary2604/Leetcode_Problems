class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()+1][p.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        boolean ans=solve(s,p,s.length(),p.length(),dp);
        return ans;
    }
    public boolean solve(String s,String p,int i,int j,int[][] dp){
        if(i==0 && j==0){
            return true;
        }
        if(i>0 && j==0){
            return false;
        }
        if(i==00 && j>0){
            for(int k=0;k<j;k++){
                if(p.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        boolean ans;
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            ans = solve(s, p, i - 1, j - 1, dp);
        } else if (p.charAt(j - 1) == '*') {
            ans = (solve(s, p, i, j - 1, dp) || solve(s, p, i - 1, j, dp));
        } else {
            ans = false;
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
        
}