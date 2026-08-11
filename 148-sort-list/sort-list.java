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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=middle(head);
        ListNode slow=head;
        ListNode fast=mid.next;
        mid.next=null;
        slow=sortList(slow);
        fast=sortList(fast);
        return merge(slow,fast);
        
    }
    public ListNode middle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                temp.next=list2;
                list2=list2.next;
                temp=temp.next;
            }
            else{
                temp.next=list1;
                list1=list1.next;
                temp=temp.next;
            }
        }
        if(list1!=null){
            temp.next=list1;
        }
        if(list2!=null){
            temp.next=list2;
        }
        return dummy.next;
    }
}