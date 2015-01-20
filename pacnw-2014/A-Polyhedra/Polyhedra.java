import java.util.*;

public class Polyhedra {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int testCases = s.nextInt();
    for(int i = 0; i < testCases; i++) {
      int vertices = s.nextInt();
      int edges = s.nextInt();
      System.out.println(2 - vertices + edges);
    }
  }
}
