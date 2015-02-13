/*
	Partition List
	Given a linked list and a value x, partition it such that all nodes less than x 
	come before nodes greater than or equal to x.
	You should preserve the original relative order of the nodes in each of the two partitions.

	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
     public ListNode partition(ListNode head, int x) {
    	if (head == null || head.next == null)
    		return head;
    	ListNode small = new ListNode(-1);
    	ListNode smallhead = small;
    	ListNode large = new ListNode(-1);
    	ListNode largehead = large;

    	while (head != null) {
    		if (head.val < x) {
    			small.next = head;
    			small = small.next;
    		} else {
    			large.next = head;
    			large = large.next;
    		}
    		head = head.next;
    	}
    	//最后别忘了 larg最后的指针要指向null
    	//small 最后的指针指向larg的头结点。
    	large.next = null;
    	small.next = largehead.next;
    	return smallhead.next;
    }
}