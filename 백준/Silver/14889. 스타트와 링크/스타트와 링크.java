import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;         

	static void dfs(int depth, int start) {
		if (depth == N / 2) {
			int startTeam = 0;
			int linkTeam = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i+1; j < N; j++) {
					if (visited[i] == true && visited[j] == true) {
						startTeam += arr[i][j];
						startTeam += arr[j][i];
					} else if (visited[i] == false && visited[j] == false) {
						linkTeam += arr[i][j];
						linkTeam += arr[j][i];
					}
				}
			}
			int value = Math.abs(startTeam - linkTeam);
			ans = Math.min(ans, value);
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		dfs(0,0);
		System.out.println(ans);

	}

}
