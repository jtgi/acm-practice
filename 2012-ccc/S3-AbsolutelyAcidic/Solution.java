import java.util.*;
import java.awt.*;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Point[] counts = new Point[1001];

    for(int j = 0; j < counts.length; j++) {
      counts[j] = new Point(j, 0);
    }

    int n = s.nextInt();

    for(int i = 0; i < n; i++)
      counts[s.nextInt()].y++;

    Comparator<Point> highCountsFirst = new Comparator<Point>() {
      public int compare(Point p1, Point p2) {
        return Integer.compare(p2.y, p1.y);
      }
    };

    Comparator<Point> highValueFirst = new Comparator<Point>() {
      public int compare(Point p1, Point p2) {
        return Integer.compare(p2.x, p1.x);
      }
    };

    Arrays.sort(counts, highCountsFirst);

    int k = 0;
    int maxCount = counts[k].y;

    ArrayList<Point> first = new ArrayList<Point>();
    ArrayList<Point> second = new ArrayList<Point>();

    while(k < counts.length && counts[k].y == maxCount)  {
      first.add(counts[k]);
      k++;
    }

    maxCount = counts[k].y;

    while(k < counts.length && counts[k].y == maxCount ) {
      second.add(counts[k]);
      k++;
    }


    int maxDiff = 0;

    if(first.size() > 1) {
      Collections.sort(first, highValueFirst);
      maxDiff = Math.abs(first.get(0).x - first.get(first.size() - 1).x);
    } else {
      int highVal = first.get(0).x;
      Collections.sort(second, highValueFirst);

      for(Point p : second) {
        int diff = Math.abs(highVal - p.x);
        if(diff > maxDiff) 
          maxDiff = diff;
      }
    }

    System.out.println(maxDiff);

  }

}
