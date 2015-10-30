import java.util.*;

public class UniqueBinarySearchTreesII {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        if (n <= 0) {
            List<TreeNode> result = new ArrayList<>();
            result.add(null);
            return result;
        }
        HashMap<String, List<TreeNode>> cache = new HashMap<>();
        return generateTrees(1, n, cache);
    }
    
    /**
     * @paramn start: the smallest element of this tree
     * @paramn end: the greatest element of this tree
     * @paramn cache: used for caching the trees
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int start, int end, HashMap<String, List<TreeNode>> cache) {
        String key = String.valueOf(start) + "-" + String.valueOf(end);
        //return the tree if it's already generated, we will end up with multiple nodes pointing to the same subnode
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (start > end) {
            return null;
        }
        if (start == end) {
            List<TreeNode> list = new ArrayList<>();
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        List<TreeNode> result = new ArrayList<>();
        //root's value could be anywhere from start to end 
        for (int root = start; root <= end; root++) {
            List<TreeNode> left = generateTrees(start, root - 1, cache);
            List<TreeNode> right = generateTrees(root + 1, end, cache);
            //case 1 : left child is null
            if (left == null) {
                for (TreeNode rightChild : right) {
                    TreeNode node = new TreeNode(root);
                    node.left = null;
                    node.right = rightChild;
                    result.add(node);
                }
            //case 2 : right child is null    
            } else if (right == null) {
                for (TreeNode leftChild : left) {
                    TreeNode node = new TreeNode(root);
                    node.left = leftChild;
                    node.right = null;
                    result.add(node);
                }   
            //case 3 : left and right child are both not null    
            } else {
                for (TreeNode leftChild : left) {
                    for (TreeNode rightChild : right) {
                        TreeNode node = new TreeNode(root);
                        node.left = leftChild;
                        node.right = rightChild;
                        result.add(node);
                    }
                }
            }
        }
        //cache the result
        cache.put(key, result);
        return result;
    }
}
