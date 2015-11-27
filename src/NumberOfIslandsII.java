import java.util.*;

public class NumberOfIslandsII {
    
    public class Island{
        public Island root;
        public int row, col, size;
        public Island(int row, int col) {
            this.row = row;
            this.col = col;
            size = 1;
            root = this;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (positions == null || positions.length == 0 || positions[0].length == 0)
            return new ArrayList<>();
            
        List<Integer> result = new ArrayList<>();
        
        Island[][] islands = new Island[m][n];
        
        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            int last = (result.size() == 0) ? 0 : result.get(result.size() - 1);
            
            if (row < 0 || row >= m || col < 0 || col >= n) {
                result.add(last);
                continue;
            }
            
            if (islands[row][col] != null) {
                result.add(last);
            } else {
                int ori_size = countIslands(islands, row, col);
                islands[row][col] = new Island(row, col);
                unionIslands(islands, row, col);
                int size = countIslands(islands, row, col);
                result.add(last + size - ori_size);
            }
        }
        
        return result;
    }
    
    public void unionIslands(Island[][] islands, int row, int col) {
        if (row - 1 >= 0)
            union(islands[row-1][col], islands[row][col]);
        if (row + 1 < islands.length)
            union(islands[row+1][col], islands[row][col]);
        if (col - 1 >= 0)
            union(islands[row][col - 1], islands[row][col]);
        if (col + 1 < islands[0].length)
            union(islands[row][col+1], islands[row][col]);
    }
    
    public void union(Island i1, Island i2) {
        if (i1 == null || i2 == null)
            return;
            
        Island r1 = find(i1);
        Island r2 = find(i2);
        if (r1 == r2)
            return;
            
        if (r1.size < r2.size) {
            r1.root = r2;
            r2.size += r1.size;
        } else {
            r2.root = r1;
            r1.size += r2.size;
        }
    }
    
    public int countIslands(Island[][] islands, int row, int col) {
        HashSet<Island> set = new HashSet<>();
        Island r0 = (islands[row][col] == null) ? null : find(islands[row][col]);
        Island r1 = (row > 0) ? find(islands[row-1][col]) : null;
        Island r2 = (row + 1 < islands.length) ? find(islands[row+1][col]) : null;
        Island r3 = (col > 0) ? find(islands[row][col - 1]) : null;
        Island r4 = (col + 1 < islands[0].length) ? find(islands[row][col+1]) : null;
        
        if (r0 != null)
            set.add(r0);
        if (r1 != null)
            set.add(r1);
        if (r2 != null)
            set.add(r2);
        if (r3 != null)
            set.add(r3);
        if (r4 != null)
            set.add(r4);
            
        return set.size();
    }
    
    public Island find(Island island) {
        if (island == null)
            return null;
            
        if (island.root == island)
            return island;
            
        island.root = find(island.root);
        return island.root;
    }
    
    public static void main(String[] args) {
    	NumberOfIslandsII p = new NumberOfIslandsII();
    	int[][] arr = new int[][]{{0,0},{0,1},{1,2},{2,1}};
    	p.numIslands2(3, 3, arr);
    }
}
