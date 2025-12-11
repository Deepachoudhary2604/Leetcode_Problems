class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int i = 0 , j = 0;
        int n = mat.length , m = mat[0].length;
        while(i<n && j<m){
            int top = -1 , rg = -1 , btm = -1 , lf = -1;
            if(i<n-1) btm = mat[i+1][j];
            if(j<m-1) rg = mat[i][j+1];
            if(i>0) top = mat[i-1][j];
            if(j>0) lf = mat[i][j-1];
            int cur = mat[i][j];
            if(top>cur) i--;
            else if(btm > cur) i++;
            else if(rg>cur) j++;
            else if(lf>cur) j--;
            else return new int[]{i,j}; 
        }

        return new int[]{-1,-1};
    }
}