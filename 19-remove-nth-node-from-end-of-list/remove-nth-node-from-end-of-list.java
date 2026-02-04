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
        if(head==null){
            return head;
        }
        
        ListNode node=head;
        for(int i=0;i<n;i++){
            node=node.next;
        }
        if(node==null){
            return head.next;
        }
        
        ListNode node2=head;
        while(node.next!=null){
            node=node.next;
            node2=node2.next;
        }
        node2.next=node2.next.next;
        
        return head;
    }
}