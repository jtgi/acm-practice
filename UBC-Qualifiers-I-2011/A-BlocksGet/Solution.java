import java.util.*;
import java.awt.*;

public class Solution {

  public static int solve(Point start, ArrayList<Point> blocs) {
    int secs = 0;
    for(Point bloc : blocs) {
      int dx = Math.abs(bloc.x - start.x);
      int dy = Math.abs(bloc.y - start.y);
      secs += 2*(dx + dy);
    }
    return secs;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int numCases = s.nextInt();

    for(int i = 0; i < numCases; i++) {
      int m = s.nextInt();
      int n = s.nextInt();
      ArrayList<Point> blocs = new ArrayList<Point>();
      Point start = null;

      for(int k = 0; k < m; k++) {
        String line = s.next();

        for(int j = 0; j < line.length(); j++) {
          if(line.charAt(j) == 'B') {
            blocs.add(new Point(k, j));
          } else if(line.charAt(j) == 'S') {
            start = new Point(k, j);
          }
        }
      }

      System.out.println(String.format("%d seconds to blocks get!", solve(start, blocs)));
    }
  }

}
