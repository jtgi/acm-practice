import java.util.*;

public class Diamonds {

  public class Pair {
    public double x;
    public double y;

    public Pair(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  public void solve() {
    Scanner s = new Scanner(System.in);
    int numTestCases = s.nextInt();

    for(int i = 0; i < numTestCases; i++) {
      int n = s.nextInt();

      Pair[] diamonds = new Pair[n+1];
      diamonds[0] = new Pair(-1.0, 11.0);

      for(int j = 1; j <= n; j++) {
        diamonds[j] = new Pair(s.nextDouble(), s.nextDouble());
      }

      System.out.println(lds(diamonds));
    }
  }

  private static int lds(Pair[] diamonds) {
    int[] cache = new int[diamonds.length];
    Arrays.fill(cache, Integer.MIN_VALUE);
    return ldsHelp(diamonds.length - 1, diamonds, cache);
  }

  private static int ldsHelp(int i, Pair[] diamonds, int[] cache) {
    if(i == 0) return Integer.MIN_VALUE;
    if(cache[i] != Integer.MIN_VALUE) return cache[i];
    if(i == 1) return 1;

    int prevIndex = findFirstLessThan(diamonds, i);
    int without = ldsHelp(i-1, diamonds, cache);
    int with = ldsHelp(prevIndex, diamonds, cache) + 1;
    cache[i] = Math.max(without, with);
    return cache[i];
  }

  private static int findFirstLessThan(Pair[] arr, int i) {
    Pair compare = arr[i];
    i--;

    while(i >= 0) {
      if(compare.x > arr[i].x && compare.y < arr[i].y) {
        return i;
      }
      i--;
    }

    return i;
  }


  public static void main(String[] args) {
    Diamonds d = new Diamonds();
    d.solve();
  }
}
