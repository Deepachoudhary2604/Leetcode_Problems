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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> adj=new ArrayList<>();
        while(head!=null){
            adj.add(head.val);
            head=head.next;
        }
        int[] ans=new int[adj.size()];
        Stack<Integer> st=new Stack<>();
        for(int i=adj.size()-1;i>=0;i--){
            while(!st.isEmpty() && adj.get(i)>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=0;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(adj.get(i));
        }
        return ans;
    }
}