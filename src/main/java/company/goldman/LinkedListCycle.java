package company.goldman;

public class LinkedListCycle {

    public static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return cycleLength(slow);
            }
        }
return 0;
    }

    public static ListNode findStart(ListNode head, int length){
        ListNode first = head;
        ListNode second = head;

        while (length>0){
            first = first.next;
            length--;
        }

        while(first!=second){
            first= first.next;
            second = second.next;
        }
        return first;
    }

    private static int cycleLength(ListNode slow) {
        ListNode current = slow.next;
        int length = 1;
        while (current!=slow){
            current = current.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        int len1 = LinkedListCycle.findCycleLength(head);
        System.out.println("LinkedList cycle length: " + len1);
        ListNode start = LinkedListCycle.findStart(head,len1);
        System.out.println("Linked List Cycle Start: "+ start);
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycle.findCycleLength(head));
    }
}
