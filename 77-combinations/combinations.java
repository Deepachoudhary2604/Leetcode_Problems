class Solution {
    List<List<Integer>> l1=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> l2=new ArrayList<>();
        solve(1,k,l2,n);
        return l1;
    }
    public void solve(int st,int k,List<Integer> l2,int n){
        if(k==0){
            l1.add(new ArrayList<>(l2));
            return;
        }
        if (st > n) return;
        l2.add(st);
        solve(st+1,k-1,l2,n);
        l2.remove(l2.size()-1);
        solve(st+1,k,l2,n);
    }
}