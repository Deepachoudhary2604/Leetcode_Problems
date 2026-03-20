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
    public void reorderList(ListNode head) {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }


        int i=0;
        int j=list.size()-1;
        List<Integer> ans=new ArrayList<>();
        for(int k=0;k<list.size();k++){
            if(k%2==0){
                ans.add(list.get(i));
                i++;
            }
            else{
                ans.add(list.get(j));
                j--;
            }
        }

        temp=head;
        for(int k=0;k<ans.size();k++){
            temp.val=ans.get(k);
            temp=temp.next;
        }
    }
}