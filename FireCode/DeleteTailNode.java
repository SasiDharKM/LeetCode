/*
Given a singly-linked list, write a method to delete its last node and return the head.
Example:
1->2->3->4 ==> 1->2->3
*/

public ListNode deleteAtTail(ListNode head) {
    ListNode temp = head;
    if(temp == null || temp.next == null){
        return null;
    }
    while(temp.next.next != null){
        temp = temp.next;
    }
    temp.next = null;
    return head;
    
}
