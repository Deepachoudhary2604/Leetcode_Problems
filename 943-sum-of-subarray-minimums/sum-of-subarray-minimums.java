class Solution {
    int mod=1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] psl=new int[n];
        int[] psr=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                psl[i]=i+1;
            }
            else{
                psl[i]=i-st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                psr[i]=n-i;
            }
            else{
                psr[i]=st.peek()-i;
            }
            st.push(i);
        }
        long prod=0;
        for(int i=0;i<n;i++){
            prod = (prod + (long) arr[i] * psl[i] * psr[i]) % mod;
        }
        return (int)prod;
    }
}
