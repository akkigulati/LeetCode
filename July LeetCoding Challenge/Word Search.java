/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans=false;
        for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == word.charAt(0)&&ans==false) {
					ans= helper(board,word,"",i,j,new boolean[board.length][board[0].length]);
				}
			}
		}
        return ans;
    }
   
    public static boolean helper(char[][] board, String word,String asf,int i,int j,boolean [][]visited){
        boolean ans=false;
        
         if(asf.length()==word.length()){
            
            if(asf.equals(word)){
                 // System.out.println(asf);
                return true;
            }else{
                // System.out.println(asf);
                return false;
            }
         
        
        }else if(asf.equals(word.substring(0,asf.length()))==false){
           
            // System.out.println(asf+" "+word.substring(0,asf.length()));
            return false;
            
        }
        if(i<0||j<0||i==board.length||j==board[0].length||visited[i][j]==true){
            // System.out.println(asf);
            return false;
        }
        
       
        
        visited[i][j]=true;
         // System.out.println(i+" "+board.length);
        ans=helper(board,word,asf+board[i][j],i+1,j,visited)||helper(board,word,asf+board[i][j],i,j+1,visited)||helper(board,word,asf+board[i][j],i-1,j,visited)||helper(board,word,asf+board[i][j],i,j-1,visited);
          visited[i][j]=false;
        return ans;
    } 
     
}
