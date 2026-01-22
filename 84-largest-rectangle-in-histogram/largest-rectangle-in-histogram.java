class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int[] psl=new int[n];
        int[] psr=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                psl[i]=-1;
            }
            else{
                psl[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                psr[i]=n;
            }
            else{
                psr[i]=st.peek();
            }
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int h=arr[i];
            int w=psr[i]-psl[i]-1;
            ans=Math.max(ans,h*w);
        }
        return ans;
    }
}
