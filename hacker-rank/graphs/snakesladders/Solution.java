import java.util.*;
import java.awt.*;

public class Solution {

  /*
   * Problem Definition
   * ==================
   * Given a snakes and ladders board of 100 total squares
   * and a dice from 1-6, find the least number of moved 
   * required. If you arrive at a snake you must take it, same for ladders.
   *
   * You are given snakes and ladders in forms of tuples over stdin where
   * (3, 6) means a ladder at 3 takes you to 6. You must end at 100.
   *
   * Approach:
   * I took the approach of thinking about the board as a graph.
   * Where the vertices are the squares 1..100, and the edges are
   * from a given square i, i + 1, i + 2, ..., i + 6. All of a fixed
   * cost of 1 (1 roll of the dice). We can use the snake and ladder information
   * by simply checking if there exists a snake or ladder at square i + 1 ... i + 6
   * at each step of the way.
   *
   * The problem then reduces to a bfs.
   * At each step of the bfs we try to make the most progress as possible, progress
   * is defined by the highest numbered square we can get to, the cost to get to that
   * square is always the cost its taken thus far + 1, because regardless of its distance
   * (snake, ladder, or roll) rolling the dice only ever costs 1.
   *
   * The algorithm then simply enqueues all nodes FIFO style never visiting a node more than
   * once, and adding the sum of turns as we continue.
   *
   * When we reach the 100th square we can be guaraunteed that the number of turns is as good
   * or better than all other possible paths.
   *
   */

  public static int solve(int[] jumps) {
    boolean[] visited = new boolean[101];
    Queue<Vertex> q = new LinkedList<Vertex>();

    visited[1] = true;
    q.add(new Vertex(1, 0));

    while(!q.isEmpty()) {
      Vertex head = q.poll();
      if (head.index == 100) return head.turns;

      for (int i = head.index + 1; i <= head.index + 6 && i <= 100; i++) {
        if(visited[i]) 
          continue;

        visited[i] = true;
        int next = Math.max(i, jumps[i]);
        int turns = head.turns + 1;

        q.add(new Vertex(next, turns));
      }
    }

    return -1;
  }

  public static class Vertex {
    int index, turns;
    public Vertex(int index, int turns) { 
      this.index = index; this.turns = turns;
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int numCases = s.nextInt();

    for(int i = 0; i < numCases; i++) {
      int[] jumps = new int[101];

      String[] line = s.next().split(",");
      int numJumps = Integer.parseInt(line[0]) + Integer.parseInt(line[1]);

      for(int k = 0; k < numJumps; k++) {
        String[] pair = s.next().split(",");
        jumps[Integer.parseInt(pair[0])] = Integer.parseInt(pair[1]);
      }

      System.out.println(solve(jumps));
    }
  }


}
