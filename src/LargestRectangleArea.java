import java.util.*;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        //a stack to store non-decreasing bars' index
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        
        //scan through the array
        for (int i = 0; i < height.length; i++) {
            //condition one, current height is greater or equal than the top
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                    int heig = height[stack.pop()];
                    int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                    area = Math.max(area, heig * width);
                }
                stack.push(i);
            }
        }
        
        //get the rest in the stack
        while (!stack.isEmpty()) {
            int heig = height[stack.pop()];
            int width = (stack.isEmpty()) ? height.length : height.length - stack.peek() - 1;
            area = Math.max(area, heig * width);
        }
        
        return area;
    }
}
