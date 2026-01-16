
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String N;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();
        arr = new int[9];
        char[] sArr = N.toCharArray();
        for(int i=0; i<sArr.length; i++){
            int num = Integer.parseInt(String.valueOf(sArr[i]));
            if(num==9){
                arr[6] ++;
            }else{
                arr[num] ++;
            }
        }
        if(arr[6]%2 ==0){
            arr[6] = arr[6]/2;
        }else{
            arr[6] = arr[6]/2 + 1;
        }

        int maxi=Integer.MIN_VALUE;
        for(int i=0; i<9; i++){
            if(maxi < arr[i]){
                maxi = arr[i];
            }
        }
        System.out.println(maxi);

    }

}