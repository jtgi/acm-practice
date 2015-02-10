import java.util.*;

public class Solution {

  /*
   * no self cycles
   * ledang mountain has a path to all other mountains
   * each pool has a weight of teim distortion.
   * write an alg to find if there is a path such that
   * end in itself that will end up in the past.
   */
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int numCases = s.nextInt(); //1 - 20
    int NO_EDGE = 2000;

    for(int k = 0; k < numCases; k++) {
      int numNodes = s.nextInt(); //1 - 1000
      int numEdges = s.nextInt(); //0 - 2000

      int[][] graph = new int[numNodes][numNodes];
      int[] weightSum = new int[numNodes];
      Arrays.fill(weightSum, Integer.MAX_VALUE);
      weightSum[0] = 0;

      for(int[] row : graph) {
        Arrays.fill(row, NO_EDGE);
      }

      for(int i = 0; i < numEdges; i++) {
        int start = s.nextInt();
        int end = s.nextInt();
        int weight = s.nextInt();
        graph[start][end] = weight;
      }

      LinkedList<Integer> q = new LinkedList<Integer>();
      q.push(0);
      boolean solFound = false;

      while(!q.isEmpty()) {
        if(solFound) break;
        Integer head = q.pop();

        for(int j = 0; j < graph.length; j++) {
          if(graph[head][j] != NO_EDGE && (weightSum[head] + graph[head][j]) < weightSum[j]) {
            weightSum[j] = weightSum[head] + graph[head][j];

            if(j == 0) {
              if(weightSum[0] < 0) {
                System.out.println(String.format("Case #%d: %s", k+1, "possible"));
                solFound = true;
                break;
              } else {
                continue;
              }
            }

            q.push(j);
          }
        }

      }
      
        if(!solFound) {
          System.out.println(String.format("Case #%d: %s", k+1, "not possible"));
        }

    }
  }

}
