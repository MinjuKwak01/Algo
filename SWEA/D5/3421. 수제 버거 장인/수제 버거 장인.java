
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static int T, N, M;
    static boolean[] visited;
    static List<Node> nodeList;
    static int ans;

    static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static void dfs(int depth) {
        if (depth == N) {
            int cnt = 0;
          //  System.out.println(Arrays.toString(visited));
            for (int i = 0; i < nodeList.size(); i++) {
                Node n = nodeList.get(i);
                if (visited[n.a - 1] && visited[n.b - 1]) {
                    cnt++;
                    break;
                }
            }
            if (cnt == 0) {
                ans++;
            }
            return;
        }

        visited[depth] = true;
        dfs(depth + 1);

        visited[depth] = false;
        dfs(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            ans = 0;
            nodeList = new ArrayList<>();
            visited = new boolean[N];
            for (int i = 0; i < M; i++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                Node node = new Node(a, b);
                nodeList.add(node);
            }

            dfs(0);
            System.out.println("#" + (tc + 1) + " " + ans);
        }
    }
}
