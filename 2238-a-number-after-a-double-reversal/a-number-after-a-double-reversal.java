class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num<10 && num>=0){
            return true;
        }
        int rev1=reverse(num);
        int rev2=reverse(rev1);
        return num==rev2;
        
    }
    public static int reverse(int num){
        int n=0;
        while(num>0){
            int r=num%10;
            n=n*10+r;
            num=num/10;
        }
        return n;
    }
}