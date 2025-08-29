class Solution {
    public long flowerGame(int n, int m) {
        // long c=0;
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if((i+j)%2!=0){
        //             c++;
        //         }
        //     }
        // }
        // return c;
        long odd_n = (n + 1) / 2;
        long even_n = n / 2;
        long odd_m = (m + 1) / 2;
        long even_m = m / 2;
        
        return (odd_n * even_m) + (even_n * odd_m);
        
    }
}