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
    int[] dfn;
    int[] low;
    int step = 1;
    List<List<Integer>> graph = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public void tarjan(int u, int parent){
        low[u] = step;
        dfn[u] = step;
        step++;
        for(Integer v:graph.get(u)){
            if(dfn[v] == 0){
                tarjan(u,v);
                low[u] = Math.min(low[u], low[v]);
                if(low[v] > dfn[u]){
                    ArrayList<Integer> temp = new ArrayList<>();
                    if(u<v){
                        temp.add(u);
                        temp.add(v);
                    }
                    else {
                        temp.add(v);
                        temp.add(u);
                    }
                    res.add(temp);
                }
            }
            else if(v != parent){
                low[u] = Math.min(low[u], dfn[v]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        dfn = new int[n];
        low = new int[n];

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (List l: connections){
            int x = (int) l.get(0);
            int y = (int) l.get(1);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i=0; i<n; i++){
            if(dfn[i] == 0){
                tarjan(i, -1);
            }
        }

        return res;
    }
}
