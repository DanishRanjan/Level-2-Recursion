import java.io.*;
import java.util.*;

public class nQueen_Branch_And_Bound {
    
  public static void solve(boolean[][] board, int row, boolean[] cols, boolean[] normalDiagonal, boolean[] reverseDiagonal, String asf ){
      
      if(row == board.length){
          System.out.println(asf + ".");
          return;
      }
      
      for(int col = 0; col < board[0].length; col++){
          if(cols[col] == false && normalDiagonal[row + col] == false && reverseDiagonal[row - col + board.length -1]==false){
              board[row][col] = true;
              cols[col] = true;
              normalDiagonal[row+col] = true;
              reverseDiagonal[row-col + board.length - 1] = true;
              solve(board, row+1, cols, normalDiagonal, reverseDiagonal, asf + row + "-"+col+", ");
              board[row][col] = false;//backtracking
              cols[col] = false;//backtracking
              normalDiagonal[row+col] = false;//backtracking
              reverseDiagonal[row-col + board.length - 1] = false;//backtracking
          }
      }
      
  } 

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    
    
    boolean[] cols = new boolean[n];
    boolean[] normalDiagonal = new boolean[2 * n + 1]; 
    boolean[] reverseDiagonal = new boolean[2 * n + 1];
    
    solve(board, 0, cols, normalDiagonal, reverseDiagonal, "");

  }

}