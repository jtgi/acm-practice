import java.util.*;

public class AromaticNumbers {

  public static int solve(String s, Map<String, Integer> map) {
    int sum = 0;
    int prevR = 0;
    int prevTotal = 0;

    for(int i = 0; i < s.length(); i += 2) {
      int a = Integer.parseInt(Character.toString(s.charAt(i)));
      int r = map.get(Character.toString(s.charAt(i+1)));

      if(r > prevR) {
        sum -= prevTotal;
      } else {
        sum += prevTotal;
      }

      prevR = r;
      prevTotal = a * r;
    }

    return sum + prevTotal;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    Map<String, Integer> map = new HashMap<String, Integer>();

    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);

    String in = s.nextLine();
    System.out.println(Integer.toString(solve(in, map)));
  }

}
