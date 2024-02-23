package _2024._02.leetcode;

public class DeleteTheMiddleNodeOfaLinkedList {

    public static void main(String[] args) {

        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node = deleteMiddle(node1);
        while (node != null) {
            System.out.println(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode deleteMiddle(ListNode head) {
        int n = 0;
        int mid;

        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        if (n == 1) return null;

        mid = n / 2;

        ListNode prev = head;
        for (int i = 1; i < mid; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return head;
    }


     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
