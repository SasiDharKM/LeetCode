/*
Write a method to insert a node at the front of a singly-linked list and return the head of the modified list.
Examples:

LinkedList: 1->2 , Head = 1

InsertAtHead(Head,1) ==> 1->1->2
InsertAtHead(Head,2) ==> 2->1->2
InsertAtHead(Head,3) ==> 3->1->2
*/

public ListNode insertAtHead(ListNode head, int data) {
    ListNode temp = new ListNode(data);
    temp.next = head;
    head = temp;
    return head;


}
