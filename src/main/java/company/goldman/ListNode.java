package company.goldman;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    public String toString() {
        return "ListNode(value=" + this.value + ", next=" + this.next.value + ")";
    }
}
