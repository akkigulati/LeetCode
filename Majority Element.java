//https://leetcode.com/problems/majority-element/
class Solution {
    //Moore Vooting algo
    public int majorityElement(int[] nums) {
        int me=0;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[me]){
                count++;
            }else{
                count--;
            }
            if(count==0){
                count=1;
                me=i;
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[me]==nums[i]) count++;
        }
        return count>nums.length/2?nums[me]:-1;
    }
}
