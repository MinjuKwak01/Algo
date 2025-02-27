

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int t;
	static int n;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans;
	static int roomStart;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int a = 0; a < t; a++) {
			n = Integer.parseInt(br.readLine());
			ans = 0;
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dfs(i, j, 1, arr[i][j]);
				}
			}
			System.out.print("#" + (a + 1) + " ");
			System.out.print(roomStart + " ");
			System.out.println(ans);
		}

	}

	static void dfs(int x, int y, int cnt, int startNum) {
		boolean moved = false;
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}
			if (arr[nx][ny] == arr[x][y] + 1) {
				moved = true;
				dfs(nx, ny, cnt + 1, startNum);
			}
		}
		
		if(!moved) {
			if(cnt > ans || (cnt == ans && startNum < roomStart)) {
				ans = cnt;
				roomStart = startNum;
			}
		}
	}

}
