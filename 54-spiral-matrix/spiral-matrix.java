class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left=0;
        int top=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;
        int total=(right+1)*(bottom+1);
        int c=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while(c<total){
            for(int i=left;i<=right && c<total;i++){
                ans.add(matrix[top][i]);
                
                c++;
            }
            top++;
            for(int i=top;i<=bottom && c<total;i++){
                ans.add(matrix[i][right]);
                
                c++;
            }
            right--;
            for(int i=right;i>=left && c<total;i--){
                ans.add(matrix[bottom][i]);
                
                c++;
            }
            bottom--;
            for(int i=bottom;i>=top && c<total;i--){
                ans.add(matrix[i][left]);
                c++;
            }
            left++;
        }
        return ans;
    }
}