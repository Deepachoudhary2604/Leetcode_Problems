class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char dig='1';dig<='9';dig++){
                        if(isSafe(board,i,j,dig)){
                            board[i][j]=dig;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                    
                }
            }
        }
        return true;
    }
    public boolean isSafe(char[][] board,int row,int col,char dig){
        for(int i=0;i<9;i++){
            if(board[row][i]==dig){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==dig){
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==dig){
                    return false;
                }
            }
        }
        return true;
    }
}