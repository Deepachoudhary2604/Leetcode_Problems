class Solution {
    public int diagonalSum(int[][] mat) {
        int i=0;
        int j=mat[0].length-1;
        int sum=0;
        int k=0;
        while(i<mat.length && j>=0){
            if(j!=k){
                sum+=mat[i][j];
                sum+=mat[i][k]; 
            }
            else if(i==k){
                sum+=mat[i][k];
            }
            i++;
            j--;
            k++;
        
        }
        return sum;  
    }
}
