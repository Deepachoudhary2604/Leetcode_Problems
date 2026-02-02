class Solution {
    public int getDecimalValue(ListNode head) {

        String ans = "";
        ListNode node = head;
        
        while (node != null) {
            ans += node.val;
            node = node.next;
        }

        int final_ans = 0;
        int mul = 1;

        for (int i = ans.length() - 1; i >= 0; i--) {
            int bit = ans.charAt(i) - '0';
            final_ans += bit * mul;
            mul *= 2;
        }

        return final_ans;
    }
}
