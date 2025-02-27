/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 0;
        ListNode temp = head, ans = head;;
        while(temp != null){
            counter++;
            temp =temp.next;
        }
        if(n == counter){
            return head.next;
        }
        for(int i = 0; i< counter - n -1;i++){
            head = head.next;
        }
        ListNode temp2 = head.next;
        head.next = temp2.next;
        return ans;
    }
}
