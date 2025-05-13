

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int T;
    static int N;
    static List<Node> lst;
    static boolean[] visited;
    static int[] arr;
    static int res;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void dfs(int depth, Node start) {
        if (depth == N) {
            calcDist(start);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                arr[depth] = i + 2;
                visited[i] = true;
                dfs(depth + 1, start);
                visited[i] = false;
            }
        }
    }

    static void calcDist(Node start) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();

        int sum = 0;
        sum += Math.abs(lst.get(0).x - lst.get(arr[0]).x) + Math.abs(lst.get(0).y - lst.get(arr[0]).y);
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(lst.get(arr[i]).x - lst.get(arr[i + 1]).x) + Math.abs(
                    lst.get(arr[i]).y - lst.get(arr[i + 1]).y);
        }
        sum += Math.abs(lst.get(1).x - lst.get(arr[N - 1]).x) + Math.abs(lst.get(1).y - lst.get(arr[N - 1]).y);
        res = Math.min(res, sum);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            lst = new ArrayList<>();
            visited = new boolean[N];
            arr = new int[N];
            res = Integer.MAX_VALUE;
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < s.length; i += 2) {
                Node node = new Node(Integer.parseInt(s[i]), Integer.parseInt(s[i + 1]));
                lst.add(node);
            }

            dfs(0, lst.get(0));
            System.out.println("#" + tc + " " + res);
        }


    }
}
