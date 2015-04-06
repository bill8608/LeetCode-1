/*
	Excel Sheet Column Number
	Related to question Excel Sheet Column Title

	Given a column title as appear in an Excel sheet, return its corresponding column number.

	For example:
		A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
*/

public class Solution {
    public int titleToNumber(String s) {
        char[] charArr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < charArr.length; i++) {
        	res = 26 * res + charArr[i] % 64;
        }
        return res;
    }
}