class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(solve(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean solve(char[][] board, String word,int sr,int sc,int idx){

        if(idx==word.length()){
            return true;
        }


        if(sr<0 || sc<0 || sr>=board.length || sc>=board[0].length || word.charAt(idx)!=board[sr][sc]){
            return false;

        }


        char temp=board[sr][sc];
        board[sr][sc]='#';

        boolean found=solve(board,word,sr+1,sc,idx+1)||
        solve(board,word,sr-1,sc,idx+1)||
        solve(board,word,sr,sc+1,idx+1)||
        solve(board,word,sr,sc-1,idx+1);

        board[sr][sc]=temp;

        return found;
    }
}