
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);

        arr = new int[N+1];
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (left <= N && right <= N) {
            if (sum >= S) {
                answer = Math.min(answer, right - left);
                sum -= arr[left++];
            } else if (sum < S) {
                sum += arr[right++];
            }
        }
        System.out.println(answer==Integer.MAX_VALUE ? 0 : answer);

    }
}