class Solution {
    public String convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        String ans="";
        boolean flag=false;
        if(num<0){
            flag=true;
        }
        num=Math.abs(num);
        while(num>0){
            int r=num%7;
            ans+=r;
            num=num/7;
        }
        String origin="";
        for(int i=ans.length()-1;i>=0;i--){
            origin+=ans.charAt(i);
        }
        if(flag){
            return "-"+origin;
        }
        return origin;
    }
}