/*
    Follow up for "Unique Paths":
    Now consider if some obstacles are added to the grids. How many unique paths would there be?
    An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    For example,
    There is one obstacle in the middle of a 3x3 grid as illustrated below.


    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]
    The total number of unique paths is 2.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int[][] dp = new int[rowLen][colLen];

        // 遇到障碍点并且行 或者 列数为1，则break，后面自然全为0；
        for (int i = 0; i < rowLen; i++) {
            if (obstacleGrid[i][0] == 1) {
                if (colLen == 1)
                    return 0;
                break;             
            }
            else 
                dp[i][0] = 1;
        }

        for (int j = 0; j < colLen; j++) {
            if (obstacleGrid[0][j] == 1){
                if (rowLen == 1)
                    return 0;
                break;
            }
            else 
                dp[0][j] = 1;
        }

        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[rowLen - 1][colLen - 1];
    }
}