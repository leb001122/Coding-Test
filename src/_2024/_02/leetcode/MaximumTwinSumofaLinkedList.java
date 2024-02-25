package _2024._02.leetcode;

public class MaximumTwinSumofaLinkedList {

    public static void main(String[] args) {

        ListNode node5 = new ListNode(0);
        ListNode node4 = new ListNode(1, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(4, node2);
        ListNode node0 = new ListNode(5, node1);

        pairSum(node0);
    }

    public static int pairSum(ListNode head) {
        int answer = 0;

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode mid = p1;

        ListNode cur = mid.next;
        while (cur.next != null) {

            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = mid.next;
            mid.next = tmp;
//            cur = tmp;
        }

        p1 = head;
        p2 = mid.next;

        while (p2 != null) {
            int sum = p1.val + p2.val;
            if (answer < sum) answer = sum;

            p1 = p1.next;
            p2 = p2.next;
        }
        return answer;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }
}
