class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int n=numBottles;
        int m=numExchange;
        int sum=n;
        while (n >= m) {
            int newBottles = n / m;   // bottles we can get by exchange
            sum += newBottles;       // drink them
            n = newBottles + (n % m); // update: new full + leftover empties
        }
        
        return sum;
    }
}