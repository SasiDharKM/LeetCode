/**
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes
contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode add, res;
        res=l1;add=l1;
        while(l1 != null || l2 != null)
        {

            if(l1 != null && l2 != null)
                add.val= l1.val + l2.val + carry;
            else if( l1 == null)
                add.val=  l2.val + carry;

            else if( l2 == null)
                add.val=  l1.val + carry;

            carry = add.val/10;
            add.val = add.val%10;
            if(l1 != null)
                l1=l1.next;
            if(l2 != null)
                l2=l2.next;

             if(add.next==null && (carry!=0||l1!=null||l2!=null))
                add.next=new ListNode(0);
            add=add.next;
        }

        if(carry!=0)
            add.val=carry;
        return res;
    }
}
