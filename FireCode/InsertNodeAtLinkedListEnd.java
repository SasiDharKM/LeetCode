/*
Insert a Node at the End of a Linked List
Write a method to insert a node at the end of a singly-linked list.
Return the head of the modified list.
Examples:

LinkedList: 1->2 , Head = 1

InsertAtTail(Head,1) ==> 1->2->1
InsertAtTail(Head,2) ==> 1->2->2
InsertAtTail(Head,3) ==> 1->2->3
*/

public ListNode insertAtTail(ListNode head, int data) {
    ListNode temp = head;
    if(head != null){
        while(head.next != null){
            head  = head.next;
        }
        head.next = new ListNode(data);
    }
    else{
        return new ListNode(data);
    }
    return temp;
}
