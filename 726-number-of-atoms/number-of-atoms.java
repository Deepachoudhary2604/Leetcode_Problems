class Solution {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String,Integer>> st=new Stack<>();
        st.push(new HashMap<String,Integer>());
        int n=formula.length();
        int i=0;
        while(i<n){
            char ch=formula.charAt(i);
            if(ch=='('){
                st.push(new HashMap<String,Integer>());
                i++;
            }
            else if(ch==')'){
                i++;
                int mul=0;
                while(i<n && Character.isDigit(formula.charAt(i))){
                    mul=mul*10+(formula.charAt(i)-'0');
                    i++;
                }
                if(mul==0){
                    mul=1;

                }
                HashMap<String,Integer> top=st.pop();
                HashMap<String,Integer> curr=st.peek();
                for(String atom:top.keySet()){
                    curr.put(atom,curr.getOrDefault(atom,0)+top.get(atom)*mul);
                }
            }
            else{
                StringBuilder ans=new StringBuilder();
                ans.append(formula.charAt(i));
                i++;
                while(i<n && Character.isLowerCase(formula.charAt(i))){
                    ans.append(formula.charAt(i));
                    i++;
                }
                int count=0;
                while(i<n && Character.isDigit(formula.charAt(i))){
                    count=count*10+(formula.charAt(i)-'0');
                    i++;
                }
                if(count==0){
                    count=1;
                }
                Map<String, Integer> curr = st.peek();
                curr.put(ans.toString(),curr.getOrDefault(ans.toString(), 0) + count);
            }
        }
        TreeMap<String, Integer> sorted = new TreeMap<>(st.pop());
        StringBuilder ans = new StringBuilder();

        for (String atom : sorted.keySet()) {
            ans.append(atom);
            if (sorted.get(atom) > 1)
                ans.append(sorted.get(atom));
        }

        return ans.toString();
    }
}