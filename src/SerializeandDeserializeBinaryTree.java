import java.util.*;

public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        //BFS seperated by ','
        List<TreeNode> list = new ArrayList<>();
        //add the root to list and string builder
        list.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        
        while (list.size() != 0) {
            //build next level's list and add next level to sb
            List<TreeNode> next = new ArrayList<>();
            
            for (TreeNode node : list) {
                if (node.left != null) {
                    next.add(node.left);
                    sb.append(node.left.val);
                } else {
                    sb.append("#");
                }
                sb.append(",");
                
                if (node.right != null) {
                    next.add(node.right);
                    sb.append(node.right.val);
                } else {
                    sb.append("#");
                }
                sb.append(",");
            }
            
            list = next;
        }
        
        //clean the tailing "#" and ","
        String res = sb.toString();
        int last = res.length() - 1;
        while (res.charAt(last) == '#' || res.charAt(last) == ',') {
            last--;
        }
        return res.substring(0, last + 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        
        //now that convert the string to a tree
        //first convert to a string array
        String[] arr = data.split(",");
        //recursively backwards BFS
        List<TreeNode> result = getTree(0, 0, arr);
        return result.get(0);
    }
    
    public List<TreeNode> getTree(int start, int end, String[] arr) {
        
        //count how many not null nodes on this level
        int count = 0;
        List<TreeNode> result = new ArrayList<>();
        //construct nodes at this level and add then to result list
        for (int i = start; i <= end; i++) {
            if (i >= arr.length || arr[i].equals("#")) {
                result.add(null);
            } else {
                TreeNode node = new TreeNode(Integer.valueOf(arr[i]));
                result.add(node);
                count++;
            }
        }
        
        if (end >= arr.length - 1) {
            return result;
        }
        
        //get the next level list
        List<TreeNode> next = getTree(end + 1, count * 2 + end, arr);
        //build up child edges with next level's nodes
        //j <- point to the index of next level's list
        int j = 0;
        for (int i = 0; i < result.size(); i++) {
            TreeNode node = result.get(i);
            if (node != null) {
                node.left = next.get(j++);
                node.right = next.get(j++);
            }
        }
        
        return result;
    }
}
