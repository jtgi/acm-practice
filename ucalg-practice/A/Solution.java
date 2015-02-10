import java.util.*;

public class Solution {

  /*
   * alg: 
   * binary search
   * at each step
   *   return min(cost(glass + bullet), (cost of diff * bullet cost)
   */
  public static int solve(int dist, int glassCost, int bulletCost) {
    return solveAcc(dist, glassCost, bulletCost, glassCost);
  }

  /*
   * This doesn't work. prob need to take into account glass not breaking?
   */
  private static int solveAcc(int dist, int glassCost, int bulletCost, int sum) {
    if(dist == 0) return sum;
    int mid = dist / 2;

    int useGlass = (sum == 0) ? bulletCost : glassCost + bulletCost;
    int useBullets = (dist-mid) * bulletCost;
    int cost = Math.min(useGlass, useBullets);

    return solveAcc(mid, glassCost, bulletCost, sum + cost);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int numCases = s.nextInt();
    for(int i = 0; i < numCases; i++) {
      int dist = s.nextInt();
      int glassCost = s.nextInt();
      int bulletCost = s.nextInt();
      System.out.println(String.format("Case #%d: %d", i+1, solve(dist, glassCost, bulletCost)));
    }
  }
}
