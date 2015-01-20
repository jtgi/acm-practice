import java.util.*;

public class Solution {
  //find most 
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int j = s.nextInt();
    int ans = ((j-1) * (j-2) * (j-3)) / (3*2*1);
    System.out.println(ans);
  }

}
