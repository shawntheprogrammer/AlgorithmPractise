import java.util.*;

public class TrappingRainWater {
        /**
         * @param heights: an array of integers
         * @return: a integer
         */
        public int trapRainWater(int[] heights) {
            // write your code here
            if (heights == null || heights.length == 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            int water = 0;
            //scan through left to right
            //stack stores the left bar of the local convex container
            for (int i = 0; i < heights.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else if (heights[i] >= heights[stack.peek()]) {
                    int left = stack.pop();
                    //caculate the water in the local convex
                    for (int j = left + 1; j < i; j++) {
                        water += heights[left] - heights[j];
                    }
                    stack.push(i);
                } 
            }
            //the right part of the maximum height has not been calculated
            //since we only calculate water when there is right bar higher than left
            //so do the same thing but change the calculation condition to left >= right
            int left = stack.pop();
            for (int i = heights.length - 1; i >= left; i--) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else if (heights[i] >= heights[stack.peek()]) {
                    int right = stack.pop();
                    //caculate the convex
                    for (int j = right - 1; j > i; j--) {
                        water += heights[right] - heights[j];
                    }
                    stack.push(i);
                } 
            }
            return water;
        }
    }
