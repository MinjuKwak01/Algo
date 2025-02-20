import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, m;
	static boolean[] visited;
	static int[] arr;

	static void dfs(int depth, int start) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				arr[depth] = i + 1;
				visited[i] = true;
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s[] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		visited = new boolean[n];
		arr = new int[m];

		dfs(0, 0);
	}
}
