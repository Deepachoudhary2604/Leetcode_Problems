class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<trust.length;i++){
            int u=trust[i][0];
            int v=trust[i][1];
            adj.get(u).add(v);
        }

        int[] indegree=new int[n+1];

        for(int i=1;i<=n;i++){
            for(int neibr:adj.get(i)){
                indegree[neibr]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && adj.get(i).size() == 0) {
                return i;
            }
        }

        return -1;
    }
}