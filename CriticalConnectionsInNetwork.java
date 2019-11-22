/*
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.


Example 1:

Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.


Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.
*/

class Solution {

  private Map<Integer, List<Integer>> graph;
  private int[] dist;
  private int[] low;
  private int[] parent;
  private boolean[] isVisited;
  private int time;
  private List<List<Integer>> result;

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    graph = new HashMap<>();
    dist = new int[n];
    parent = new int[n];
    low = new int[n];
    time = 0;
    isVisited = new boolean[n];
    result = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new LinkedList<>());
      parent[i] = -1;
    }
    for (List<Integer> conn : connections) {
      int a = conn.get(0);
      int b = conn.get(1);
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    dfs(0);
    return result;
  }

  private void dfs(int root) {
    if (isVisited[root]) {
      return;
    }
    isVisited[root] = true;
    dist[root] = time;
    low[root] = time;
    time++;
    for (int neighbor : graph.get(root)) {
      if (!isVisited[neighbor]) {
        parent[neighbor] = root;
        dfs(neighbor);
        low[root] = Math.min(low[root], low[neighbor]);
        if (dist[root] < low[neighbor]) {
          result.add(Arrays.asList(root, neighbor));
        }
      } else if (neighbor != parent[root]) {
        low[root] = Math.min(low[root], dist[neighbor]);
      }
    }
  }
}
