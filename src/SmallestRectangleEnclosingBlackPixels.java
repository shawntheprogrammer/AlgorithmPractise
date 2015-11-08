import java.util.*;

public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        
        //keep four variables:  left , right, top, bot
        //left = Math.min(left, x)  right = Math.max(right, x); top = Math.max(top, y); bot = Math.min(bot, y)
        int[] cache = new int[]{x, x, y, y};
        
        //a list to record all the places flip 1 to 0,  so we could return the original image without modifing it
        List<int[]> list = new ArrayList<>();
        
        dfs(image, x, y, cache, list);
        
        for (int[] arr : list) {
            image[arr[0]][arr[1]] = '1';
        }
        
        return (cache[1] - cache[0] + 1) * (cache[2] - cache[3] + 1);
    }
    
    public void dfs(char[][] image, int x, int y, int[] cache, List<int[]> list) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != '1') {
            return;
        }
        image[x][y] = '0';
        
        list.add(new int[]{x, y});
        
        //update cache
        //left
        cache[0] = Math.min(cache[0], x);
        //right
        cache[1] = Math.max(cache[1], x);
        //top
        cache[2] = Math.max(cache[2], y);
        //botton
        cache[3] = Math.min(cache[3], y);
        
        //go to surroundings
        dfs(image, x + 1, y, cache, list);
        dfs(image, x - 1, y, cache, list);
        dfs(image, x, y + 1, cache, list);
        dfs(image, x, y - 1, cache, list);
    }
}
