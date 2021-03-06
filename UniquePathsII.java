/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        return MazePath(0,0,obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid,new int[obstacleGrid.length][obstacleGrid[0].length]);
    }
    public static int MazePath(int sr,int sc,int dr,int dc,int[][] obstacleGrid,int mem[][]){
        if(sr>dr||sc>dc||obstacleGrid[sr][sc]==1){
            return 0;
        }
        if(sr==dr&&sc==dc){
            // System.out.println(asf);
            return mem[sr][sc]=1;
        }
        if(mem[sr][sc]!=0){
            return mem[sr][sc];
        }
        return mem[sr][sc]=MazePath(sr+1,sc,dr,dc,obstacleGrid,mem)+MazePath(sr,sc+1,dr,dc,obstacleGrid,mem);
    }
}
