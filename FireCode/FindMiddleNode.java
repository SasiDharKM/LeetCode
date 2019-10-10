import java.utils.*;
import java.util.streams.*;

public ListNode findMiddleNode(ListNode head) {
    ListNode slow = head;
    // Using Two Pointer approach to find the middle Node:
    // One twice the speed of the other
    //one reaches end of list while at the same time other is at the middle
    if(head != null){
        ListNode fast = head;
        while(True){
            fast = fast.next;
            if(fast == null){
                break;
            }
            fast = fast.next;
            if(fast == null){
                break;
            }
            slow = slow.next;
        }
    }
    return slow;
}
