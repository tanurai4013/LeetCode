import java.util.*;

public class Solution {
    int ans = 1000000000;
    int xo = 0;
    int time = 0;

    void dfs(int node, int par, List<Integer>[] adj, int[] nums, int[] sub, int[] in, int[] out) {
        in[node] = time++;
        sub[node] = nums[node];
        for (int child : adj[node]) {
            if (child == par) continue;
            dfs(child, node, adj, nums, sub, in, out);
            sub[node] ^= sub[child];
        }
        out[node] = time++;
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            xo ^= nums[i];
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int[] sub = new int[n];
        int[] in = new int[n];
        int[] out = new int[n];
        dfs(0, -1, adj, nums, sub, in, out);
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x, y, z;
                if (in[i] < in[j] && out[i] > out[j]) {
                    x = sub[j];
                    y = sub[i] ^ sub[j];
                    z = xo ^ sub[i];
                } else if (in[i] > in[j] && out[i] < out[j]) {
                    x = sub[i];
                    y = sub[i] ^ sub[j];
                    z = xo ^ sub[j];
                } else {
                    x = sub[i];
                    y = sub[j];
                    z = xo ^ sub[i] ^ sub[j];
                }
                int mn = Math.min(x, Math.min(y, z));
                int mx = Math.max(x, Math.max(y, z));
                ans = Math.min(ans, mx - mn);
            }
        }
        return ans;
    }
}
