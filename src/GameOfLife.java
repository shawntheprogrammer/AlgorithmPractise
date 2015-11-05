
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = countLiveNeighbor(i, j, board);
                if (board[i][j] == 1) {
                    // 1 -> 0
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                } else if (count == 3) {
                    // 0 -> 1
                    board[i][j] = -1;
                }
            }
        }
        
        
        // 2 means original 1 -> next 0   -1 mean original 0 -> next 1
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    public int countLiveNeighbor(int i, int j, int[][] board) {
        int count = 0;
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        for (int index = 0; index < 8; index++) {
            int x = i + dx[index];
            int y = j + dy[index];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && (board[x][y] == 1 || board[x][y] == 2)) {
                count++;
            }
        }
        return count;
    }
}
