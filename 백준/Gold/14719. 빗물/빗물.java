

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int H, W;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] s = br.readLine().split(" ");


      H = Integer.parseInt(s[0]);
      W = Integer.parseInt(s[1]);
      arr = new int[W];

      s = br.readLine().split(" ");
      for(int i=0; i< W; i++){
          arr[i] = Integer.parseInt(s[i]);
      }

      for(int i=1; i<W-1; i++){
          int left = 0, right = 0;
          for(int j=0; j<i; j++){
              left = Math.max(left, arr[j]);
          }
          for(int j=i+1; j<W; j++){
              right = Math.max(right, arr[j]);
          }
          if(arr[i] < left && arr[i] < right)
              result += Math.min(left, right) - arr[i];
      }

        System.out.println(result);

    }

}