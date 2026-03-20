class Solution {
    public void reorderList(ListNode head) {
        ArrayList<Integer> ans=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            ans.add(temp.val);
            temp=temp.next;
        }  
        int i=0;
        int j=ans.size()-1;
        int k=0;
        while(head!=null){
            if(k%2==0){
                head.val=ans.get(i);
                k++;
                i++;
                head=head.next;
            }
            else{
                head.val=ans.get(j);
                j--;
                k++;
                head=head.next;
            }
        }
    }
}