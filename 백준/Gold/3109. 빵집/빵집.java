

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R, C;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static boolean isSuccessed;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);

		visited = new boolean[R][C];
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			boolean bol = dfs(i, 0);
			visited[i][0] = true;
			if (bol) {
				ans++;
			}
		}
		System.out.println(ans);

	}

	// DFS + 그리드 알고리즘으로 탐색하는 DFS 함수
	static boolean dfs(int x, int y) {
		if (y == C - 1) // 파이프 라인 연결 성공
			return true;

		// 파이프 연결 탐색
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// System.out.println("전 " + nx + " " + ny);

			// 파이프 연결 가능한 공간일 때
			if (inSpace(nx, ny) && !visited[nx][ny] && arr[nx][ny] == '.') {
				visited[nx][ny] = true;
				if (dfs(nx, ny)) // 파이프 연결하였을 때 파이프 라인 연결 성공시.
					return true;
				// System.out.println("후 " + nx + " " + ny);

			}
		}
		return false; // 파이프 연결하였을 때 파이프 라인 연결 실패시
	}

	static boolean inSpace(int x, int y) {
		if (x >= 0 && y >= 0 && x < R && y < C)
			return true;
		return false;
	}
}
