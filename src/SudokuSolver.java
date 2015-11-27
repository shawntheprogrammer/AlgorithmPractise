import java.util.*;

public class SudokuSolver {
	   public void solveSudoku(char[][] board) {
	        if (board == null || board.length == 0 || board[0].length == 0)
	            return;
	        
	        HashMap<Integer, HashSet<Character>> row_map = new HashMap<>();
	        HashMap<Integer, HashSet<Character>> col_map = new HashMap<>();
	        HashMap<Integer, HashSet<Character>> square_map = new HashMap<>();
	        
	        List<int[]> blanks = new ArrayList<>();
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[0].length; j++) {
	                char c = board[i][j];
	                if (!row_map.containsKey(i))
	                    row_map.put(i, new HashSet<>());
	                if (!col_map.containsKey(j))
	                    col_map.put(j, new HashSet<>());
	                int cluster = (i / 3) * 3 + j / 3;
	                if (!square_map.containsKey(cluster))
	                    square_map.put(cluster, new HashSet<>());
	                if (c == '.') {
	                    blanks.add(new int[]{i, j});
	                    continue;
	                }
	                row_map.get(i).add(c);
	                col_map.get(j).add(c);
	                square_map.get(cluster).add(c);
	            }
	        }
	        
	        solve(board, blanks, 0, row_map, col_map, square_map);
	        
	    }
	    
	    public boolean solve(char[][] board, List<int[]> blanks, int index, HashMap<Integer, HashSet<Character>> row_map, HashMap<Integer, HashSet<Character>> col_map, HashMap<Integer, HashSet<Character>> square_map) {
	        if (index == blanks.size())
	            return true;
	            
	        int[] pos = blanks.get(index);
	        int row = pos[0];
	        int col = pos[1];
	        HashSet<Character> row_set = row_map.get(row);
	        HashSet<Character> col_set = col_map.get(col);
	        HashSet<Character> square_set = square_map.get((row / 3) * 3 + col / 3);
	        
	        for (char c = '1'; c <= '9'; c++) {
	            if (!row_set.contains(c) && !col_set.contains(c) && !square_set.contains(c)) {
	                board[row][col] = c;
	                row_set.add(c);
	                col_set.add(c);
	                square_set.add(c);
	                if (solve(board, blanks, index + 1, row_map, col_map, square_map))
	                    return true;
	                row_set.remove(c);
	                col_set.remove(c);
	                square_set.remove(c);
	            }
	        }
	        
	        return false;
	    }
}
