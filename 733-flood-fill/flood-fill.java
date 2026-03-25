class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int curr=image[sr][sc];
        if(curr==color){
            return image;
        }
        helper(image,sr,sc,color,curr);
        return image;
    }
    public void helper(int[][] image,int sr,int sc,int color,int curr){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=curr){
            return;
        }
        image[sr][sc]=color;
        helper(image,sr+1,sc,color,curr);
        helper(image,sr-1,sc,color,curr);
        helper(image,sr,sc-1,color,curr);
        helper(image,sr,sc+1,color,curr);

    }
}