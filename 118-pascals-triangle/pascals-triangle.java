class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        int row=0;
        int star=1;
        while(row<numRows){
            int val=1;
            int i=0;
            List<Integer> temp=new ArrayList<>();
            while(i<star){
                temp.add(val);
                val=((row-i)*val)/(i+1);
                i++;
            }
            star++;
            row++;
            ans.add(temp);
        }
        return ans;
    }
}