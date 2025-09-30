class Solution {
    public int countPrimes(int n) {
        boolean[] arr=new boolean[n+1];
        if(n<2){
            return 0;
        }
        
        int count=0;
        Arrays.fill(arr,true);
        for(int i=2;i<n;i++){
            if(arr[i]){
                count++;
            }
            for(int j=i*2;j<n;j=j+i){
                arr[j]=false;
            }
        }
        return count;
    }
    
}
