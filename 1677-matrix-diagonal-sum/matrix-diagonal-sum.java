class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int i=0;
        int j=mat[0].length-1;
        for(int k=0;k<mat.length;k++){
            if(i==j){
                sum+=mat[i][i];
            }
            else{
                sum+=mat[k][j];
                sum+=mat[k][i];
            }
            i++;
            j--;
        }
        return sum;
    }
}
