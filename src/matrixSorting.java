import java.util.*;

public class matrixSorting {
    
    public static int[] sortMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        
        return mergeSort(0, matrix.length - 1, matrix);
    }
    
    public static int[] mergeSort(int start, int end, int[][] matrix) {
        if (start == end) {
            return matrix[start]; 
        }
        if (start > end) {
            return new int[]{};
        }
        int mid = start + (end - start) / 2;
        int[] left = mergeSort(start, mid, matrix);
        int[] right = mergeSort(mid + 1, end, matrix);
        return merge(left, right);
    }
    
    public static int[] merge(int[] left, int[] right) {
        if (left.length == 0) {
            return right;
        }
        if (right.length == 0) {
            return left;
        }
        int[] result = new int[left.length + right.length];
        
        // i <- index in left  j <- index in right  k <- index in result
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i++];
            } else {
                result[k] = right[j++];
            }
            k++;
        }
        
        //add the rest in left or right
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{2,2,4};
        matrix[1] = new int[]{3,5,5};
        matrix[2] = new int[]{4,5,5};
        System.out.println(Arrays.toString(sortMatrix(matrix)));
        
    }

}
