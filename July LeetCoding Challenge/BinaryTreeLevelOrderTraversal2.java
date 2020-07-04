/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
   
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       
    List<List<Integer>> result = new  ArrayList<List<Integer>>();
    if(root == null){
        return result;
    }
    Queue <TreeNode> mq = new ArrayDeque<>();
    mq.add(root);
   
   
int count=1;
    while(mq.size()>0)
        {  
        
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for(int i=0;i<count;i++ )
        {  
            root=mq.remove();
     //       System.out.println(root.val);
              numberList.add(root.val);
    
         if(root.left!=null)
        {
            mq.add(root.left);
        }
         if(root.right!=null)
        {
            mq.add(root.right);
        }
                         
             
       }
        count=mq.size();
        result.add(numberList);
    }
       
   
    List<List<Integer>> reversedResult = new  ArrayList<List<Integer>>();
    for(int i=result.size()-1; i>=0; i--){
        reversedResult.add(result.get(i));
    }
 
    return reversedResult;
    }
}
