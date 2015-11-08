import java.util.*;

public class RouteBetweenTwoNodesInGraph {
    /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (s == t) {
            return true;
        }
        return bfs(graph, s, t);
    }
    
    public boolean bfs (ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        HashSet<DirectedGraphNode> visited = new HashSet<>();
        
        List<DirectedGraphNode> list = new ArrayList<>();
        list.add(s);
        
        while (list.size() != 0) {
            List<DirectedGraphNode> next = new ArrayList<>();
            
            for (DirectedGraphNode node : list) {
                for (int i = 0; i < node.neighbors.size(); i++) {
                    DirectedGraphNode neighbor = node.neighbors.get(i);
                    if (neighbor == t) {
                        return true;
                    }
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    next.add(neighbor);
                }
                visited.add(node);
            }
            
            list = next;
        }
        
        return false;                        
    }
}
