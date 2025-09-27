class Solution {
    public int countPrimes(int n) {
        Boolean[] isPrime=new Boolean[n+1];
        Arrays.fill(isPrime,true);
        int ans=0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                ans++;
            }
            for(int j=i*2;j<n;j=j+i){
                isPrime[j]=false;
            }
        }
        return ans;
    }
    
}
