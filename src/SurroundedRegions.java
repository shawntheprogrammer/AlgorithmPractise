import java.util.*;
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        //three ways 1. scan through, if 'O' -> dfs mark the surrounded 'O' to 'X', the non-surrounded to 'K', then all 'K' to 'O'
        //           2. start from boarder, if 'O' -> dfs all neighboring 'O' to 'K', then all 'K' to 'O', all 'O' to 'X'
       
        List<List<Integer>> lists = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') 
                lists.add(getList(board, row, 0));
            if (board[row][board[0].length - 1] == 'O') 
                lists.add(getList(board, row, board[0].length - 1));
        }
        
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') 
                lists.add(getList(board, 0, col));
            if (board[board.length - 1][col] == 'O') 
                lists.add(getList(board, board.length - 1, col));
        }
        
        bfs(lists, board);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'K')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    
    public List<Integer> getList(char[][] board, int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        board[i][j] = 'K';
        return list;
    }
    
    public void bfs(List<List<Integer>> neighbors, char[][] board) {
        while (neighbors.size() != 0) {
            List<List<Integer>> next = new ArrayList<>();
            
            for (List<Integer> neighbor : neighbors) {
                int x = neighbor.get(0);
                int y = neighbor.get(1);
                
                //add the neighbors of the neighbor to next, if it's O
                int[] dx = new int[]{0, 0, 1, -1};
                int[] dy = new int[]{-1, 1, 0, 0};
                
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'O') {
                        next.add(getList(board, nx, ny));
                    }
                }
            }
            
            neighbors = next;
        }
    }
}
