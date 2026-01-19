
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i=2; i*i<=N; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=N; j+=i){
                    isPrime[j] = false;
                }
            }
        }


        for(int i=M; i<=N; i++){
            if(isPrime[i]){
                System.out.println(i);
            }
        }

    }
}
