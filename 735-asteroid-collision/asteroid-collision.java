class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int val2=asteroids[i];
            while(!st.isEmpty() && st.peek()>0 && val2<0){
                int val1=st.peek();
                if(Math.abs(val1)>Math.abs(val2)){
                    val2=0;
                    break;
                }
                if(Math.abs(val2)>Math.abs(val1)){
                    st.pop();
                }
                else{
                    st.pop();
                    val2=0;
                    break;
                }
            }
            if(val2!=0){
                st.push(val2);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}
