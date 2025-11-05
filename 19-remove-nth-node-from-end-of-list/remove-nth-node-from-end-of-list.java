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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt=0;
        ListNode curr=head;
        while(curr!=null){
            cnt++;
            curr=curr.next;
        }
        if(n==cnt){
            return head.next;
        }
        curr=head;
        for(int i=1;i<cnt-n;i++){
            curr=curr.next;

        }
        curr.next=curr.next.next;
        return head;
    }
}