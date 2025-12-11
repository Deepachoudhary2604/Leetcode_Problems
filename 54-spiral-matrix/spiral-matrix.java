class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int left=0;
        int bottom=matrix.length-1;
        int right=matrix[0].length-1;
        int n=0;
        int p=(bottom+1)*(right+1);
        List<Integer> list=new ArrayList<>();
        while(n<p){
            for(int j = left; j <= right && n<p ; j++){
                list.add(matrix[top][j]);
                n++;
            }
            top++;

            // right col
            for (int i = top; i <= bottom && n<p ; i++){
                list.add(matrix[i][right]);
                n++;
            }
            right--;

            // bottom row
            for (int j = right; j >= left && n<p ; j--){
                list.add(matrix[bottom][j]);
                n++;
            }
            bottom--;

            // left col
            for (int i = bottom; i >= top && n<p; i--){
                list.add(matrix[i][left]);
                n++;
            }
            left++;

        }
        return list;
    }
}