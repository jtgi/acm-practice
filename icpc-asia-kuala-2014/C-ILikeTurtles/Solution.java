import java.util.*;
import java.awt.*;

public class Solution {


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();

    for(int i = 0; i < n; i++) {
      Point pos = new Point(s.nextInt(), s.nextInt());
      String path = s.next();
      HashMap<Point, Integer> visits = new HashMap<Point, Integer>();
      int dupes = 0;

      int dir = 0;
      int up = 0;
      int right = 1;
      int down = 2;
      int left = 3;

      for(int j = 0; j < path.length(); j++) {
        if(path.charAt(j) == 'F') {

          if(dir == up)  {
            pos.y++;
          } else if(dir == right) {
            pos.x++;
          } else if(dir == left) {
            pos.x--;
          } else if(dir == down) {
            pos.y--;
          }

          if(!visits.containsKey(pos)) {
            visits.put(pos, 0);
          }

          visits.put(pos, visits.get(pos) + 1);

          if(visits.get(pos) == 2) {
            dupes++;
          }

        } else if(path.charAt(j) == 'R') {
          dir = (dir + 1) % 4;
        } else if(path.charAt(j) == 'L') {
          dir = (dir - 1) < 0 ? left : dir - 1;
        }
      }

      System.out.println(String.format("Case #%d: %d %d %d", i+1, pos.x, pos.y, dupes));
    }
  }

}
