import java.util.*;

public class Solution {

  private static boolean test(int target, int[] keys, int numOps, int sum) {
    if(numOps == 0 && sum == target) return true;
    if(numOps == 0 || sum >= target) return false;

    System.out.println(String.format("target: %d, sum: %d, keys: %s, numOps: %d", target, sum, Arrays.toString(keys), numOps));

    boolean found = false;

    for(int i = 0; i < keys.length; i++) {
      found = test(target, keys, numOps - 1, sum + keys[i]) ||
              test(target, keys, numOps - 1, (sum == 0) ? keys[i] : sum * keys[i]);
    }

    return found;
  }


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int numOps = s.nextInt();
    int numWorkingKeys = s.nextInt();
    int[] keys = new int[numWorkingKeys];

    for(int i = 0; i < numWorkingKeys; i++) {
      keys[i] = s.nextInt();
    }

    int numTargets = s.nextInt();
    int[] targets = new int[numTargets];

    for(int i = 0; i < numTargets; i++) {
      targets[i] = s.nextInt();
    }

    for(int target : targets) {
      //for each num try + and * with itself
      //and without if ever = to sum print y
      //if terminates print n
      //
      //poss(z, digits, times) = poss(z-digit[0], digits) || poss(z, digits(z, digits[1:])
      //poss(0, _, 0) = true
      //poss(z < 0, _, _) = false
      //poss(_, _, times < 0) = false;
      System.out.println(test(target, keys, numOps * 2, 0));
    }

  }
}
