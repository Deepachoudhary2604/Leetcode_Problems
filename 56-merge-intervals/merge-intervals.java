class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int ps=intervals[0][0];
        int pe=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int cs=intervals[i][0];
            int ce=intervals[i][1];
            if(pe>=cs){
                pe=Math.max(pe,ce);
            }
            else{
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(ps);
                temp.add(pe);
                ans.add(temp);
                ps=cs;
                pe=ce;
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(ps);
        temp.add(pe);
        ans.add(temp);
        int[][] arr=new int[ans.size()][2];
        int k=0;
        for(ArrayList<Integer> i:ans){
            int s=i.get(0);
            int e=i.get(1);
            arr[k][0]=s;
            arr[k][1]=e;
            k++;
        }
        return arr;
    }
}