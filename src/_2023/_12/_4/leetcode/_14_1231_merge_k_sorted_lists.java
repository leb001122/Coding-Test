package _2023._12._4.leetcode;

import java.util.PriorityQueue;

/**
 * 입력 리스트가 이미 오름차순으로 정렬되어 있다는 것이 중요!
 */
public class _14_1231_merge_k_sorted_lists {

    public static void main(String[] args) {
        _14_1231_merge_k_sorted_lists p = new _14_1231_merge_k_sorted_lists();

        // test code
        ListNode[] arr = new ListNode[2];
        ListNode node = new ListNode(-2);
        node.next = new ListNode(-1);
        node.next.next = new ListNode(-1);
        node.next.next.next = new ListNode(-1);
        arr[0] = node;

        ListNode res = p.mergeKLists(arr);
        while (res != null) {
            System.out.print(res.val + " ");
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));

        // 각 연결리스트의 첫 번째 노드를 queue에 저장
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode root = new ListNode(); // dummy
        ListNode cur = root;

        // queue에 저장된 노드들 중 가장 작은 노드을 결과에 추가하고 그 노드의 다음노드를 queue에 추가
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;

            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return root.next;
    }

     static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) {

             this.val = val;
             this.next = next;
         }
     }
}
