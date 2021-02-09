package company.goldman;

public class LinkedListRemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode sentinel = new ListNode(0);
        ListNode pred = sentinel;


        while(head!=null){
            if(head.next!=null && head.value == head.next.value){
                while(head.next!=null && head.value == head.next.value){
                    head = head.next;
                }
            }
            pred.next = head;
            pred = pred.next;
            head = head.next;

        }
        return sentinel.next;
    }

    public ListNode deleteAllDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0);

        ListNode pred = sentinel;


        while(head!=null){

            if(head.next!=null && head.value == head.next.value){

                while(head.next!=null && head.value == head.next.value){

                    head = head.next;
                }

                pred.next = head.next;

            }else{
                pred = pred.next;
            }

            head = head.next;

        }
        return sentinel.next;
    }
}
