
import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static int[] nums;
    static int N;
    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        nums = new int[M];
        sb = new StringBuilder();

        arr = new int[N];
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if(depth == M) {
            for(int n : nums)
                sb.append(n).append(" ");
            sb.append("\n");
        } else {
            int before = 0; //같은 depth에 중복값이 들어가지 않도록 관리
            for(int i = start; i < N; i++) {
                if(before != arr[i]) {
                    nums[depth] = arr[i];
                    before = arr[i];
                    dfs(i, depth+1);
                } else continue;
            }
        }
    }
}