class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        int row=0;
        int star=1;
        
        while(row<numRows){
            int i=0;
            int val=1;
            List<Integer> arr=new ArrayList<>();
            while(i<star){
                arr.add(val);
                val=(row-i)*val/(i+1);
                i++;
            }
            ans.add(arr);
            row++;
            star++;


        }
        return ans;
    }
}