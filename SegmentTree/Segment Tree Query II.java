/*
	Segment Tree Query II

	Medium Segment Tree Query II

	28% Accepted
	For an array, we can build a SegmentTree for it, each node stores an extra attribute count to denote the number of elements in the the array which value is between interval start and end. (The array may not fully filled by elements)

	Design a query method with three parameters root, start and end, find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.

	Example
		For array [0, 2, 3], the corresponding value Segment Tree is:

		                     [0, 3, count=3]
		                     /             \
		          [0,1,count=1]             [2,3,count=2]
		          /         \               /            \
		   [0,0,count=1] [1,1,count=0] [2,2,count=1], [3,3,count=1]
		query(1, 1), return 0

		query(1, 2), return 1

		query(2, 3), return 2

		query(0, 2), return 2

	Note
		It is much easier to understand this problem if you finished Segment Tree Buildand Segment Tree Query first.
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start > end || root == null) {
            return 0;
        }
        if (start <= root.start && root.end <= end) {
            return root.count;
        }
        
        int mid = (root.start + root.end) / 2;
        int leftsum = 0, rightsum = 0;
        
        //left side
        if (start <= mid && root.left != null) {
            if (mid < end) {
                leftsum = query(root.left, start, mid);
            } else {
                leftsum = query(root.left, start, end);
            }
        }
        
        //right side
        
        if (mid < end && root.right != null) {
            if (start <= mid) {
                rightsum = query(root.right, mid + 1, end);
            } else {
                rightsum = query(root.right, start, end);
            }
            
        }
        
        return leftsum + rightsum;
    }
}