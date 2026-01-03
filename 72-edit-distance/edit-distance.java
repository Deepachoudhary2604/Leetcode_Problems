class Solution {
    int[][] dp=new int[501][501];
    public int minDistance(String word1, String word2) {
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return min(word1,word2,0,0);
    }
    public int min(String s1,String s2,int i,int j){
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=min(s1,s2,i+1,j+1);
        }
        int delete=1+min(s1,s2,i+1,j);
        int insert=1+min(s1,s2,i,j+1);
        int replace=1+min(s1,s2,i+1,j+1);
        return dp[i][j]=Math.min(delete,Math.min(insert,replace));
    }
}