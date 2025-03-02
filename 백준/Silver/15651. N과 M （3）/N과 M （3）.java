import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] arr;
  //  static boolean[] visited;
    static StringBuilder sb;

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            // if (!visited[i]) {
            //  visited[i] = true;
            arr[depth] = i + 1;
            dfs(depth + 1);
            //  visited[i] = false;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        sb = new StringBuilder();
        //visited = new boolean[N];
        arr = new int[M];
        dfs(0);
        System.out.print(sb);

    }

}
