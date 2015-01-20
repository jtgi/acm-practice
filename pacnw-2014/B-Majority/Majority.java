import java.util.*;

public class Majority {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int numCases = s.nextInt();

    for(int i = 0; i < numCases; i++) {
      int len = s.nextInt();
      int max = Integer.MAX_VALUE;
      int maxAmt = Integer.MIN_VALUE;

      Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

      for(int j = 0; j < len; j++) {
        int num = s.nextInt();
        if(!counts.containsKey(num)) {
          counts.put(num, 0);
        }

        int amt = counts.get(num) + 1;
        counts.put(num, amt);

        if((amt == maxAmt && num < max) || amt > maxAmt) {
            max = num;
            maxAmt = amt;
        }

      }

      System.out.println(max);
    }
  }

}
