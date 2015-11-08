
public class SetMatrixZeroes {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int row = -1;
        int col = -1;
        //find a 0's row and col  make it as flag
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                }
            }
        }
        
        //there is no 0 in the matrix
        if (row == -1) {
            return;
        }
        
        //now let the row col be the flag
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[row][j] = 0;
                    matrix[i][col] = 0;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == row || j == col) {
                    continue;
                }
                if (matrix[i][col] == 0 || matrix[row][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++)
            matrix[i][col] = 0;
            
        for (int j = 0; j < matrix[0].length; j++)
            matrix[row][j] = 0;
    }
}
