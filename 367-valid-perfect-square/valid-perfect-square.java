class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2){
            return true;
        }
        int s=1;
        int e=num/2;
        while(s<=e){
            int mid=s+(e-s)/2;
            long val=(long)mid*mid;
            if(val==num){
                return true;
            }
            else if(val>num){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return false;
    }
}