import java.util.*;

public class DontPassTheBall {

  /*
   * j = [1, 99]
   * a goal is valid only if the if the players that touched
   * the ball prior are in increasing order finishing the with
   * player j.
   *
   * Given j count possible scoring combinations.
   *
   * same as asking for combinations of 3 increasing numbers
   * less than j.
   *
   * ways we can construct an increasing series of length 4
   * ending with 5
   *
   * ways(3, 5)
   * 1 2 5 O
   * 1 3 5 O
   * 1 4 5 O
   * 1 5 5 X
   * 2 3 5 O
   * 2 4 5 O
   * 2 5 5 X
   * 3 4 5 O
   * 3 5 5 X
   * 4 5 5 X
   * 5 5 5 X
   *
   * base case when index == n (4) return 1
   * base case when remaining end val - current val > indexRemaining return 0
   *
   *
   * 
   * 3, 3
   */
  public static int solve(int endNum, int remaining, int start) {
    if(remaining == 0) return 1;
    if(start >= endNum) return 0;
    if(endNum - start < remaining) return 0;
    
    int sum = 0;
    for(int i = 1; i < endNum - 1; i++) {
      sum += solve(endNum, remaining, start + 1);
    }

    return sum;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while(true) {
      int j = s.nextInt();
      System.out.println(Integer.toString(solve(j, 4-1, 0)));
    }
  }

}
