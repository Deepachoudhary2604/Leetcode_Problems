class Solution {
    public int myAtoi(String s) {

        s = s.trim();
        if(s.length()==0) return 0;

        boolean flag=false;

        if(s.charAt(0)=='-'){
            flag=true;
        }

        int val=s.charAt(0);

        if((val < 48 || val > 57) && val != 45 && val != 43){
            return 0;
        }

        long num=0;
        int i=0;

        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            i=1;
        }

        for(;i<s.length();i++){

            char ch = s.charAt(i);

            if(ch<'0' || ch>'9'){
                break;
            }

            num = num*10 + (ch-'0');

            if(!flag && num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(flag && -num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return flag ? (int)-num : (int)num;
    }
}