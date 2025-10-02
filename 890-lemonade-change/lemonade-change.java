class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            if(bills[i]==10){
                if(five==0){
                    return false;
                }
                else{
                    five--;
                }
                ten++;
            }
            if (bills[i] == 20) {
                if (ten > 0 && five > 0) {
                    ten--;  // use one $10
                    five--; // use one $5
                } else if (five >= 3) {
                    five -= 3; // use three $5s
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}