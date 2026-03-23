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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int c=0;
        while(c<k){
            if(temp==null){
                return head;
            }
            temp=temp.next;
            c++;
        }
        ListNode prev=reverseKGroup(temp,k);
        c=0;
        temp=head;
        while(c<k){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
            c++;
        }
        return prev;
    }
}