/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
  static  String phone[]={
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
       List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            List<String> res=new ArrayList<>();
            return res;
        }
        
            char ch=digits.charAt(0);
            int n=Integer.parseInt(""+ch);
            digits=digits.substring(1);
            
            String lett=phone[n];
            for(int i=0;i<lett.length();i++){
                char d=lett.charAt(i);
                List<String> comb=letterCombinations(digits);
                if(comb.size()==0){
                    comb.add("");
                }
                for(String s:comb){
                    ans.add(d+s);
                }
                
            }
       
        return ans;
    }
}
