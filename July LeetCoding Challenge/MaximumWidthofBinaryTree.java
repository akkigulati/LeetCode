/*
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).

*/
class Solution {
    private int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<Integer> startOfLevel = new LinkedList<>();
        helper(root, 0, 1, startOfLevel);
        return max;
    }
    public void helper(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null) return;
        if (level == list.size()) list.add(index);
        max = Math.max(max, index + 1 - list.get(level));
        helper(root.left, level + 1, index * 2, list);
        helper(root.right, level + 1, index * 2 + 1, list);
    }
}
/*
class Solution {
    List<Integer> mins;
    List<Integer> maxs;
    int maxWidth;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        mins = new ArrayList<>();
        maxs = new ArrayList<>();
        maxWidth = 0;
        traverse(root, 0, 0);
        return maxWidth;
    }
    
    private void traverse(TreeNode node, int level, int val) {
        if (node == null) {
            return;
        }
        if (mins.size() <= level) {
            mins.add(val);
        }
        mins.set(level, Math.min(mins.get(level), val));
        if (maxs.size() <= level) {
            maxs.add(val);
        }
        maxs.set(level, Math.max(maxs.get(level), val));
        maxWidth = Math.max(maxWidth, maxs.get(level) - mins.get(level) + 1);
        traverse(node.left, level + 1, 2 * val);
        traverse(node.right, level + 1, 2 * val + 1);
    }
}
*/
/*
class Solution {
   	public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        q.offer(root);
        map.put(root, 1);
        int max = -1;
        while(!q.isEmpty()){
            int size = q.size();
            int start = -1, end = -1;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(i == 0) 
                    start = map.get(temp);
                if(i == size - 1)
                    end = map.get(temp);
                if(temp.left != null){
                    q.offer(temp.left);
                    map.put(temp.left, map.get(temp) * 2);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                    map.put(temp.right, map.get(temp) * 2 + 1);
                }
            }
            max = max > (end-start + 1) ? max : (end-start + 1);
        }
        return max;
    }

}
*/
