import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[]{};
        }
        int[] result = new int[numCourses];
        //there is no prerequisites, just return an arbitrary order
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        //visit status map  course number -> visit status
        HashMap<Integer, String> status = new HashMap<>();
        
        //convert prerequisites matrix to adjacent list
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int after = prerequisites[i][0];
            int before = prerequisites[i][1];
            if (!adj.containsKey(before)) {
                adj.put(before, new ArrayList<Integer>());
            }
            adj.get(before).add(after);
        }
        
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            //unvisited
            if (!status.containsKey(i)) {
                //dfs also check if there is a cycle
                if (!dfs(i, list, adj, status)) {
                    return new int[]{};
                }
            }
        }
        
        //convert list to int array
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public boolean dfs(int i, List<Integer> list, HashMap<Integer, List<Integer>> adj, HashMap<Integer, String> status) {
        //change status to visiting
        status.put(i, "visiting");
        //this class is not the prerequisite of any class 
        if (!adj.containsKey(i)) {
            status.put(i, "visited");
            list.add(0, i);
            return true;
        }
        
        for (Integer neighbor : adj.get(i)) {
            //unvisited neighbor
            if (!status.containsKey(neighbor)) {
                //visit this neighbor and also check if there is a cycle
                if (!dfs(neighbor, list, adj, status)) {
                    return false;
                }
            }
            //find a cycle
            else if (status.get(neighbor).equals("visiting")) {
                return false;
            }
        }
        
        status.put(i, "visited");
        list.add(0, i);
        return true;
    }
}
