import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int rows = s.nextInt();
    int cols = s.nextInt();
    int[][] sol = new int[rows+1][cols+1];
    int[][] cats = new int[rows+1][cols+1];

    int n = s.nextInt();
    for(int i = 0; i < n; i++) {
      cats[s.nextInt()][s.nextInt()] = 1;
    }

    int numWays = 0;

    /*
     * 0 0 0 0
     * 0 1 1 1
     * 0 1 2 C
     * 0 1 3 3
     */
    for(int i = 1; i <= rows; i++) {
      for(int j = 1; j <= cols; j++) {
        if(cats[i][j] == 1) {
          sol[i][j] = 0;
        } else if(i == 1 && j == 1) {
          sol[i][j] = 1;
        } else {
          sol[i][j] = sol[i-1][j] + sol[i][j-1];
        }
      }
    }

    System.out.println(sol[rows][cols]);
  }
}
