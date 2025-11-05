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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            ListNode item=pq.poll();
            dummy.next=item;
            dummy=dummy.next;
            if(item.next!=null){
                pq.add(item.next);
            }
        }
        return temp.next;
    }
}

































