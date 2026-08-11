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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(head!=null){
            int c=0;
            ListNode curr=head;
            while(head!=null && curr.val==head.val){
                c++;
                head=head.next;
            }
            if(c==1){
                temp.next=curr;
                temp=temp.next;
                temp.next=null;
            }
        }
        return dummy.next;
    }
}