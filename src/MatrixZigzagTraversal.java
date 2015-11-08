
public class MatrixZigzagTraversal {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix == null) {
            return null;
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        int total_round = matrix.length + matrix[0].length - 1;
        
        for (int round = 1; round <= total_round; round++) {
            //i odd  left bot to right top
            if (round % 2 == 1) {
                int row = (round >= matrix.length) ? matrix.length - 1 : round - 1;
                int col = (round >= matrix.length) ? round - matrix.length : 0;
                while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
                    result[index++] = matrix[row--][col++];
                }
            //even round  right top to left bot
            } else {
                int row = (round >= matrix[0].length) ? round - matrix[0].length : 0;;
                int col = (round >= matrix[0].length) ? matrix[0].length - 1 : round - 1;
                while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
                    result[index++] = matrix[row++][col--];
                }
            }
        }
        return result;
    }
}
