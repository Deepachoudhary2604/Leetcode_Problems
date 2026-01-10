class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb,
                                 int start, int end) {

        // Build graph
        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            adj.get(u).add(new double[]{v, p});
            adj.get(v).add(new double[]{u, p});
        }

        // Probability array
        double[] prob = new double[n];
        prob[start] = 1.0;

        // Max heap: {probability, node}
        PriorityQueue<double[]> pq =
                new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        pq.add(new double[]{1.0, start});

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            double currProb = curr[0];
            int node = (int) curr[1];

            if (node == end) {
                return currProb;
            }

            if (currProb < prob[node]) continue;
            prob[node]=currProb;
            for (double[] nei : adj.get(node)) {
                int next = (int) nei[0];
                double edgeProb = nei[1];

                double newProb = currProb * edgeProb;

                if (newProb > prob[next]) {
                    prob[next] = newProb;
                    pq.add(new double[]{newProb, next});
                }
            }
        }

        return 0.0;
    }
}
