/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return sub(nums,0);
    }
    static public List<List<Integer>> sub(int[] nums,int i) {
      
        List<List<Integer>> ans=new ArrayList<>();
        
        if(nums.length==i){
            List<List<Integer>> base=new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        
       List<List<Integer>> res= sub(nums,i+1);
        
        for(List<Integer> a: res){
            ans.add(new ArrayList<>(a));
        }
        for(List<Integer> b: res){
            b.add(0,nums[i]);
            ans.add(new ArrayList<>(b));
        }
        return ans;
    }
}
