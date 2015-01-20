import java.util.*;

public class LongestIncreasingSubsequence {

  public static int lis(double[] weights, double[] clarity) {
    int[] sol = new int[weights.length];
    lisHelper(weights, clarity, weights.length-1, sol);
    return max(sol);
  }

  // lis(i) = 1 + max(lis(j)),    for all 0 <= j < i, where val(j) < val(i)
  //          1                   otherwise
  private static int lisHelper(double[] weights, double[] clarity, int index, int[] sol) {
    if(index == 0) {
      sol[index] = 1;
      return 1;
    }

    int max = 1;

    for(int i = 0; i < index; i++) {

      if(sol[i] == 0) {
        sol[i] = lisHelper(weights, clarity, i, sol);
      }

      if((weights[i] < weights[index] && clarity[i] > clarity[index]) && sol[i] + 1 > max) {
        max = sol[i] + 1;
      }

    }

    sol[index] = max;
    return sol[index];
  }

  private static int max(int[] arr) {
    int max = Integer.MIN_VALUE;
    for(int i : arr) {
      if(i > max) {
        max = i;
      }
    }
    return max;
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int numTestCases = s.nextInt();

    for(int i = 0; i < numTestCases; i++) {
      int n = s.nextInt();

      double[] weights = new double[n];
      double[] clarity = new double[n];

      for(int j = 0; j < n; j++) {
        weights[j] = s.nextDouble();
        clarity[j] = s.nextDouble();
      }

      System.out.println(lis(weights, clarity));
    }

  }

}
