class Solution {
    public int totalSteps(int[] nums) {
        int res=0;
        int n=nums.length;
        Stack<int[]> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            int step=0;
            while(!st.isEmpty() && nums[i]>st.peek()[0]){
                step=Math.max(step+1,st.peek()[1]);
                st.pop();
            }
            res=Math.max(res,step);
            st.push(new int[]{nums[i],step});
        }
        return res;
    }
}
