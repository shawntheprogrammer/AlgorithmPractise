import java.util.*;

public class ValidSudoku {
    /**
     * @param board: the board
       @return: wether the Sudoku is valid
     */
   public boolean isValidSudoku(char[][] board) {
       if (board == null || board.length != 9 || board[0].length != 9) {
           return false;
       }
       
       //check rows
       for (int row = 0; row < board.length; row++) {
           char[] arr = board[row];
           HashSet<Character> set = new HashSet<>();
           for (int i = 0; i < arr.length; i++) {
               if (arr[i] == '.') {
                   continue;
               }
               if (set.contains(arr[i])) {
                   return false;
               } else {
                   set.add(arr[i]);
               }
           }
       }
       
       
       //check cols
       for (int col = 0; col < board[0].length; col++) {
           HashSet<Character> set = new HashSet<>();
           for (int row = 0; row < board.length; row++) {
               if (board[row][col] == '.') {
                   continue;
               }
               if (set.contains(board[row][col])) {
                   return false;
               } else {
                   set.add(board[row][col]);
               }
           }
       }
       
       
       //check each smaller board
       for (int row = 0; row <= 6; row+=3) {
           for (int col = 0; col <= 6; col+=3) {
               HashSet<Character> set = new HashSet<>();
               int[] dx = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
               int[] dy = new int[]{0, 1, 2, 0, 1, 2, 0, 1, 2};
               for (int k = 0; k < dx.length; k++) {
                   char c = board[row + dx[k]][col + dy[k]];
                   if (c == '.') {
                       continue;
                   }
                   if (set.contains(c)) {
                       return false;
                   } else {
                       set.add(c);
                   }
               }
           }
       }
       
       return true;
   }
}
