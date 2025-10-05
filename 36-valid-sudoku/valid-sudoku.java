class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!check(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean check(char[][] board, int row, int col, char dig) {
        for(int i=0;i<9;i++){
            if(i!=col && board[row][i]==dig){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(i!=row && board[i][col]==dig){
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if((i!=row || j!=col) && board[i][j]==dig){
                    return false;
                }
            }
        }
        return true;
    }
}
