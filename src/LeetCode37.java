class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    
    public boolean backtrack(char[][] board, int row, int col) {
        //traverse from left top to bottom right
        if (col == 9) { //checked all row elements. Continue with next one.
            return backtrack(board, row + 1, 0);
        }
        
        if (row == 9) {
            return true; //we reached the bottom right and found solution.
        }
        
        if (board[row][col] != '.') {//already set. Check next element. 
            return backtrack(board, row, col + 1);
        }
        
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c) == false) {
                continue;
            }
            board[row][col] = c;
            
            if (backtrack(board, row, col + 1) == true) {
                
                return true;
            }
            
            board[row][col] = '.';
        }
        
        return false;
    }
    
    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c 
                || board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) {//check for 3 x 3 piece
                return false;
            }
        }
        return true;
    }
}