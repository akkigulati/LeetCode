/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> qu=new ArrayDeque<>();
        qu.add(root);
        TreeNode delim=new TreeNode(Integer.MAX_VALUE);
        qu.add(delim);
        
        List<Integer> i=new ArrayList<>();
        int level=0;
        
        while(qu.size()>0){
            TreeNode temp=qu.remove();
            if(temp==delim){
                if(level%2==0)
                ans.add(i);
                else{
                    Collections.reverse(i);
                    ans.add(i);
                }
                i=new ArrayList<>();
                if(qu.size()>0){
                    qu.add(delim);
                }
                level++;
            }else{
                i.add(temp.val);
                    if(temp.left!=null)
                      qu.add(temp.left);
                    if(temp.right!=null)
                       qu.add(temp.right);
                
            }
        }
        return ans;
    }
}
