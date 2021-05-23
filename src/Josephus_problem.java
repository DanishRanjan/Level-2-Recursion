import java.io.*;
import java.util.*;

public class Josephus_problem {

  public static int solution(int n, int k){
    if(n==1){return 0;}
        
        int x = solution(n-1,k);
        int y = (x + k)%n;
        return y;
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    System.out.println(solution(n,k));
  }
  
        //leetcode answer 1823
        //return (n == 1) ? 1 : (findTheWinner(n - 1, k) + k - 1) % n + 1;
}