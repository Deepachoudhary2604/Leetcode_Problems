class Solution {
    public int compress(char[] chars) {

        String ans="";
        int count=1;

        for(int i=1;i<=chars.length;i++){

            if(i<chars.length && chars[i]==chars[i-1]){
                count++;
            }
            else{

                ans+=chars[i-1];

                if(count>1){
                    ans+=count;
                }

                count=1;
            }
        }

        for(int i=0;i<ans.length();i++){
            chars[i]=ans.charAt(i);
        }

        return ans.length();
    }
}