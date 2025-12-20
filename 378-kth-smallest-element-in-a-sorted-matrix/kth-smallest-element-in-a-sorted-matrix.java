class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                arr.add(matrix[i][j]);
            }
        }
        Collections.sort(arr);
        if(k>arr.size() || arr.size()==0){
            return -1;
        }
        return arr.get(k-1);

    }
}