import java.util.*;
import java.awt.*;

public class Solution {

  public static int solve(int[] nums) {
    int partition = 0;
    int minIndex = 0;
    int minDiff = Integer.MAX_VALUE;
    int maxLeft, minLeft, maxRight, minRight;

    for(int i = 0; i < nums.length; i++) {
      partition = i;
      maxLeft = maxRight = Integer.MIN_VALUE;
      minLeft = minRight = Integer.MAX_VALUE;

      for(int j = 0; j <= partition; j++) {
        maxLeft = Math.max(maxLeft, nums[j]);
        minLeft = Math.min(minLeft, nums[j]);
      }

      for(int k = partition + 1; k < nums.length; k++) {
        maxRight = Math.max(maxRight, nums[k]);
        minRight = Math.min(minRight, nums[k]);
      }

      int diff = Math.max(maxLeft - minLeft, maxRight - minRight);
      minIndex = (diff < minDiff) ? partition : minIndex;
      minDiff = Math.min(diff, minDiff);
    }

    return minIndex + 1;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    while(true) {
      int numInts = s.nextInt();
      if(numInts == 1) break;

      int[] nums = new int[numInts];

      for(int i = 0; i < numInts; i++) {
        nums[i] = s.nextInt();
      }

      System.out.println(solve(nums));
    }

  }

}
