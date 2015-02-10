import java.util.*;

public class Solution {

  /*
   * This doesn't work. prob need to take into account glass not breaking?
   */
  public static int solve(String code) {
    return solveHelper(code, 0);
  }

  //123
  //1
  //12
  private static int solveHelper(String digits, int start) {
    if(start > digits.length()) return 0;
    if(start == digits.length()) return 1;

    int takeTwo = 0;
    if(start + 2 <= digits.length()) {
       int alphaNum = Integer.parseInt(digits.substring(start, start + 2));
       takeTwo = (alphaNum < 27 && alphaNum > 0) ? solveHelper(digits, start + 2) : 0;
    }

    int takeOne = (digits.charAt(start) == '0') ? 0 : solveHelper(digits, start+1);

    return takeTwo + takeOne;
  }



  //         0
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int numCases = s.nextInt();
    for(int i = 0; i < numCases; i++) {
      System.out.println(String.format("Case #%d: %d", i+1, solve(s.next())));
    }
  }
}
