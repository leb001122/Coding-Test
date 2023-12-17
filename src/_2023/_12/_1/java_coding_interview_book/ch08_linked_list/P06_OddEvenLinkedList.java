package _2023._12._1.java_coding_interview_book.ch08_linked_list;

public class P06_OddEvenLinkedList {

    // 0ms 시간복잡도 O(N) 공간복잡도 O(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;

        int i = 1;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
