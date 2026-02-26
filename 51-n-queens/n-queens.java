class Solution {    
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        helper(arr,0);
        return ans;
    }
    public void helper(char[][] arr,int row){
        int n=arr.length;
        if(n==row){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                String str="";
                for(int j=0;j<n;j++){
                    str+=arr[i][j];
                }
                temp.add(str);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(arr,row,i)){
                arr[row][i]='Q';
                helper(arr,row+1);
                arr[row][i]='.';
            }
        }
    }
    public boolean isSafe(char[][] arr,int row,int col){
        for(int i=0;i<arr.length;i++){
            if(arr[row][i]=='Q'){
                return false;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i][col]=='Q'){
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
        while(i<arr.length && j>=0){
            if(arr[i][j]=='Q'){
                return false;
            }
            i++;
            j--;
        }
        i=row;
        j=col;
        while(i<arr.length && j<arr.length){
            if(arr[i][j]=='Q'){
                return false;
            }
            i++;
            j++;
        }
        i=row;
        j=col;
        while(i>=0 && j<arr.length){
            if(arr[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}