
public class ContainerWithMostWater {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        //fix length then find the max at that length
        //reduce length  by 1 each time
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            if (heights[left] >= heights[right]) {
                right--;
            } else {
                left++;
            }
            max = Math.max(max, width * height);
        }
        return max;
    }
}
