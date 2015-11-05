
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        //project people into one dimension into rows and cols
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        return getDistance(rows) + getDistance(cols);
    }
    
    public int getDistance(int[] array) {
        //move left when there is less people on left side, vice versa for right
        int numLeft = array[0];
        int numRight = array[array.length - 1];
        int left = 0;
        int right = array.length - 1;
        while (left != right) {
            if (numLeft <= numRight) {
                left++;
                numLeft += array[left];
            } else {
                right--;
                numRight += array[right];
            }
        }
        
        //get the sum distance
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int dis = (int)Math.abs(i - left);
            sum += array[i] * dis;
        }
        return sum;
    }
}
