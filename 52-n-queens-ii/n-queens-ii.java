class Solution {
    public int totalNQueens(int n) {
        char[][] arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        List<List<String>> ans=new ArrayList<>();
        helper(arr,ans,0);
        return ans.size();
    }
    public void helper(char[][] arr,List<List<String>> ans,int row){
        int n=arr.length;
        if(row==n){
            List<String> l=new ArrayList<>();
            for(int i=0;i<n;i++){
                String str="";
                for(int j=0;j<n;j++){
                    str+=arr[i][j];
                }
                l.add(str);
            }
            ans.add(l);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(arr,row,i)){
                arr[row][i]='Q';
                helper(arr,ans,row+1);
                arr[row][i]='.';
            }
        }
    }
    public boolean isSafe(char[][] arr,int row,int col){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[row][i]=='Q'){
                return false;
            }
        }
        for(int j=0;j<n;j++){
            if(arr[j][col]=='Q'){
                return false;
            }
        }
        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(arr[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        i=row;
        j=col;
        while(i>=0 && j<n){
            if(arr[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        i=row;
        j=col;
        while(i<n && j>=0){
            if(arr[i][j]=='Q'){
                return false;
            }
            i++;
            j--;
        }
        i=row;
        j=col;
        while(i<n && j<n){
            if(arr[i][j]=='Q'){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}