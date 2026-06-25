class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.isEmpty()){
                st.push(ch);
            }
            else if(st.peek()==ch){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        String str="";
        while(!st.isEmpty()){
            str+=st.pop();
        }
        String ans=reverse(str);
        return ans;
    }
    public String reverse(String str){
        char[] arr=str.toCharArray();
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            char temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
        String ans="";
        for(char ch:arr){
            ans+=ch;
        }
        return ans;
    }
}