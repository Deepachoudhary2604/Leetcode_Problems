class Solution {

    // Check if placing a digit at board[row][col] is valid
    public boolean areRulesMet(char[][] board, int row, int col, char digit) {
        // Check if the digit exists in the same row or column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
        }

        // Check if the digit exists in the 3x3 subgrid
        int startRow = row-row%3;
        int startCol = col-col%3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true; // The placement is valid
    }

    // Recursive function to solve the Sudoku board
    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If the current cell is empty, try placing digits
                if (board[i][j] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (areRulesMet(board, i, j, digit)) {
                            board[i][j] = digit; // Place the digit

                            // Recurse to solve the rest of the board
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack if the placement doesn't lead to a solution
                            board[i][j] = '.';
                        }
                    }

                    // If no valid digit can be placed, return false
                    return false;
                }
            }
        }

        // If the entire board is filled correctly, return true
        return true;
    }

    // Public function to solve the Sudoku board
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}