/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {

        // Edge case
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers
        ListNode even = head;        // 1st node
        ListNode odd = head.next;   // 2nd node

        // Save start of odd list
        ListNode oddHead = odd;

        // Rearranging
        while (even.next != null && odd.next != null) {

            even.next = odd.next;   // link even nodes
            even = even.next;       // move even pointer

            odd.next = even.next;   // link odd nodes
            odd = odd.next;         // move odd pointer
        }

        // Attach odd list after even list
        even.next = oddHead;

        return head;
    }
}
