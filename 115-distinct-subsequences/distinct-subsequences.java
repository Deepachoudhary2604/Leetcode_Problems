class Solution {
  public int numDistinct(String s, String t) {
    int[][] dp=new int[s.length()][t.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return dist(s,t,0,0,dp);
    }
    public static int dist(String s,String t,int i,int j,int[][] dp){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int inc=0;
        int exe=0;
        if(s.charAt(i)==t.charAt(j)){
            inc=dist(s,t,i+1,j+1,dp);
        }
        exe=dist(s,t,i+1,j,dp);
        
        
        return dp[i][j]=inc+exe;
    }
}