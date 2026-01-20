class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            if (a > 0) {
                st.push(a);
            } else {
                // destroy smaller positive asteroids
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -a) {
                    st.pop();
                }

                if (!st.isEmpty() && st.peek() == -a) {
                    // both explode
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    // no collision
                    st.push(a);
                }
            }
        }

        // convert stack to array
        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
