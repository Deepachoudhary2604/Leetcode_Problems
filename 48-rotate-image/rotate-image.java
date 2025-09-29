class Solution {
    public void rotate(int[][] matrix) {
       transpose(matrix);
       reverse(matrix);
    }
    public static void transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[i].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    public static void reverse(int[][] matrix){
        for(int[] arr:matrix){
            int s=0;
            int e=arr.length-1;
            while(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
    }
}