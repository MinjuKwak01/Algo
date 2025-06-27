
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        //abcdefghijklmnopqrstuvwxyz
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                int asci = s.charAt(i) + 32;
                arr[asci-97] ++;
            }else{
                arr[s.charAt(i)-97] ++;
            }
        }

        int max = 0;
        int cnt = 0;
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] == max){
                cnt++;
            }
        }
        //System.out.println(Arrays.toString(arr));
        if(cnt > 1){
            System.out.println("?");
        }else{ // 0 + x = 65
            System.out.println((char)(index + 65));
        }
    }
}
