/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists){
            if(head != null){
                minHeap.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!minHeap.isEmpty()){
            ListNode temp = minHeap.remove();
            head.next = new ListNode(temp.val);
            head = head.next;
            if(temp.next != null){
                minHeap.add(temp.next);
            }
        }

        return dummy.next;
    }
}
