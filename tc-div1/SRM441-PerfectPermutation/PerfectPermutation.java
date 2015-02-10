public class PerfectPermutation {
    /*
     Problem Statement
     A permutation A[0], A[1], ..., A[N-1] is a sequence containing each integer between 0 and N-1, inclusive, exactly once. Each permutation A of length N has a corresponding child array B of the same length, where B is defined as follows:
     B[0] = 0
     B[i] = A[B[i-1]], for every i between 1 and N-1, inclusive.
     A permutation is considered perfect if its child array is also a permutation.

     Below are given all permutations for N=3 with their child arrays. Note that for two of these permutations ({1, 2, 0} and {2, 0, 1}) the child array is also a permutation, so these two permutations are perfect.

     Permutation   Child array
     {0, 1, 2}   {0, 0, 0}
     {0, 2, 1}   {0, 0, 0}
     {1, 0, 2}   {0, 1, 0}
     {1, 2, 0}   {0, 1, 2}
     {2, 0, 1}   {0, 2, 1}
     {2, 1, 0}   {0, 2, 0}

     You are given a int[] P containing a permutation of length N. Find a perfect permutation Q of the same length such that the difference between P and Q is as small as possible, and return this difference. The difference between P and Q is the number of indices i for which P[i] and Q[i] are different.
  */

  public int reorder(int[] P) {
    boolean[] seen = new boolean[P.length];
    int index = 0, i = 0, cycles = 0;

    while(i < P.length) {
      index = i;

      while(!seen[index]) {
        seen[index] = true;
        index = P[index];
      }
      
      cycles++;
      while(i < P.length && seen[i]) i++;
    }

    return (cycles == 0) ? 1 : cycles;
  }

}
