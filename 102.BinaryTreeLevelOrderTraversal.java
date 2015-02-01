/*
	Binary Tree Level Order Traversal
	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	For example:
	Given binary tree {3,9,20,#,#,15,7},
		3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
  	  [3],
  	  [9,20],
  	  [15,7]
	]
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int curNodeNum = 1;//to record the number of node which in same level
		int nexNodeNum = 0;//to record the number of node which in next level
		ArrayList<Integer> levelres = new ArrayList<Integer>();// store every result array in same level 
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			curNodeNum--;
			levelres.add(cur.val);

			if (cur.left != null) {
				nexNodeNum++;
				queue.add(cur.left);
			}
			if (cur.right != null) {
				nexNodeNum++;
				queue.add(cur.right);
			}

			//假如一个层上的结点数量为0，则表示该层遍历完，开始下一层的遍历，next设为cur
			if (curNodeNum == 0) {
				curNodeNum = nexNodeNum;
				nexNodeNum = 0;
				res.add(levelres);
				levelres = new ArrayList<Integer>();
			}
		}
		return res;
	}

	//DFS Solution
	public List<List<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		dfs (root, res, 0);
		return res;
	}

	public void dfs(TreeNode root, ArrayList<ArrayList<Integer>> res, int depth) {
		if (root == null)
			return ;
		if (depth >= res.size()) 
			res.add(new LinkedList<Integer>());
		res.get(depth).add(node.val);
		dfs(root.left, res, depth + 1);
		dfs(root.right, res, depth + 1);
	}
}