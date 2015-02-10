public class Solution {

  /*
   *
   * this problem, more plainly says:
   *  is there a path in the graph that contains all edges in a cycle.
   * [1, 5], [2, 8], [3, 4]
   * [3, 4], [1, 5], [2, 8]
   *
   * for each node n1 that has n2 where n1.x == n2.y and n1 != n2
   * brute force
   *      
   */
  public static String dfs(int v, int n, boolean[][] edges, boolean[][] visited, int sum) {
    for(int i = 1; i < edges.length; i++) {
      if(edges[v][i] && sum == n && visited[v][i])
        return "Yes";
      if(edges[v][i] && !visited[v][i]) {
        visited[v][i] = true;
        return dfs(i, n, edges, visited);
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int testCases = s.nextInt();
    int numVertices = 25;

    for(int i = 0; i < testCases; i++) {
      boolean[][] graph = new boolean[numVertices+1][numVertices+1];
      boolean[][] visited = graph.clone();

      int numMagnets = s.nextInt();
      for(int j = 0; j < numMagnets; j++) {
        magnets[s.nextInt()][s.nextInt()] = true;
      }

      System.out.println(String.format("Case #%d: %s", i+1, dfs(1, numVertices, graph, visited)));
    }
  }
}
