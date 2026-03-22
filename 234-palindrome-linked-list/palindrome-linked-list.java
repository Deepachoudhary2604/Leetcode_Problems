class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        if(head.next==null){
            return true;
        }
        ListNode middle=find(head);
        ListNode first=head;
        ListNode second=Reverse(middle.next);
        while(second!=null){
            if(first.val!=second.val){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;
    }
    public ListNode find(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode Reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        return prev;
    }
}