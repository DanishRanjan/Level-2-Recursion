import java.io.*;
import java.util.*;

public class combination1 {

  public static void combinations(int cb, int tb, int ssf, int ritems, String asf){
    
    if(cb>tb){
        if(ssf==ritems){
            System.out.println(asf);
        }
        return;
    }
    
    
    combinations(cb + 1, tb, ssf+1, ritems,asf + "i");
    combinations(cb + 1, tb, ssf, ritems,asf + "-");
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}