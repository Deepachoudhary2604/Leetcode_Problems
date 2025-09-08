class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        for(int i=1;i<n;i++){
            int a=i;
            int b=n-i;
            if (isValid(a) && isValid(b)) {
                return new int[]{a, b};
            }
        }
        return new int[0];
    }

    public boolean isValid(int num) {
        while (num > 0) {
            if (num % 10 == 0) return false;
            num /= 10;
        }
        return true;
            
        }
        
    }
