
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int N = A*B*C;
        int[] arr = new int[10];
        String S = String.valueOf(N);

        for(int i = 0; i <S.length(); i ++){
            int a = S.charAt(i)-'0';
            arr[a]++;
        }

        for(int i = 0; i<10; i++){
            System.out.println(arr[i]);
        }

    }
}
