/*
	Edit Distance 
	Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

	You have the following 3 operations permitted on a word:

	a) Insert a character
	b) Delete a character
	c) Replace a character
*/


/*
	dp[i][j] 表示从word1的前i个字符到word2的前j个字符所需要的最少的转变步数

	a)insert: dp[i][j] = dp[i][j-1] + 1;
	b)delete: dp[i][j] = dp[i]-1[j] + 1; 
	c)replace: dp[i][j] = dp[i-1][j-1] + 1;

 // 动态数组dp[word1.length+1][word2.length+1]
    // dp[i][j]表示从word1前i个字符转换到word2前j个字符最少的步骤数。
    // 假设word1现在遍历到字符x，word2遍历到字符y（word1当前遍历到的长度为i，word2为j）。
    // 以下两种可能性：
    // 1. x==y，那么不用做任何编辑操作，所以dp[i][j] = dp[i-1][j-1]
    // 2. x != y
    //   (1) 在word1插入y， 那么dp[i][j] = dp[i-1][j] + 1
    //   (2) 在word1删除x， 那么dp[i][j] = dp[i][j-1] + 1
    //   (3) 把word1中的x用y来替换，那么dp[i][j] = dp[i-1][j-1] + 1
    // 最少的步骤就是取这三个中的最小值。最后返回 dp[word1.length+1][word2.length+1] 即可。
*/
public class Solution {
	 public int minDistance(String word1, String word2) {
	 	int len1 = word1.length();
	 	int len2 = word2.length();
	 	int[][] dp = new int[len1 + 1][len2 + 1];
	 	dp[0][0] = 0;

	 	for (int i = 1; i <= len1; i++) 
	 		dp[i][0] = i;
	 	for (int j = 1; j <= len2; j++) 
	 		dp[0][j] = j;

	 	for (int i = 1; i <= len1; i++) {
	 		char c1 = word1.charAt(i - 1);
	 		for (int j = 1; j <= len2; j++) {
	 			char c2 = word2.charAt(j - 1);
	 			if (c1 == c2)
	 				dp[i][j] = dp[i - 1][j - 1];
	 			else {
	 				int insert = dp[i-1][j] + 1;
	 				int delete = dp[i][j-1] + 1;
	 				int replace = dp[i - 1][j - 1] + 1;
	 				int min = Math.min(insert, delete);
	 				dp[i][j] = Math.min(min, replace);
	 			}
	 		}
	 	}
	 	return dp[len1][len2];
	 }
}