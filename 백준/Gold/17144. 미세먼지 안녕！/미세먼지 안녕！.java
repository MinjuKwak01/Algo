import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		StringTokenizer st = new StringTokenizer(string);

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] arr = new int[R][C];
		int[][] move = new int[R][C];
		int air = -1;
		for (int i = 0; i < R; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
				if (air == -1 && arr[i][j] == -1) {
					air = i;
				}
			}
		}

		for (int k = 0; k < T; k++) {
			arr[air][0] = arr[air+1][0] = -1;
			move = spread(R, C, arr);
			operateAirPurifier(R, C, air, move);
			arr = move;
		}

		int result = calculateResult(R, C, arr);
		System.out.println(result);
	}

	private static int[][] spread(int R, int C, int[][] arr) {
		int[][] move = new int[R][C];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					int n = arr[i][j] / 5;
					int cnt = 0;
					for (int z = 0; z < 4; z++) {
						int nx = i + dx[z];
						int ny = j + dy[z];

						if (nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny] == -1)
							continue;
						move[nx][ny] += n;
						cnt++;
					}
					move[i][j] += arr[i][j] - (n * cnt);
				}
			}
		}
		return move;
	}

	private static void operateAirPurifier(int R, int C, int air, int[][] move) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// 위쪽 공기 순환
		int[] direct1 = { 0, 3, 1, 2 };
		int x = air - 1;
		int y = 0;
		for (int i = 0; i < 4; i++) {
			while (true) {
				int nx = x + dx[direct1[i]];
				int ny = y + dy[direct1[i]];
				if (nx < 0 || nx > air || ny < 0 || ny >= C)
					break;
				if (nx == air && ny == 0) {
					move[x][y] = 0;
					break;
				}
				move[x][y] = move[nx][ny];
				x = nx;
				y = ny;
			}
		}

		// 아래쪽 공기 순환
		int[] direct2 = { 1, 3, 0, 2 };
		x = air + 2;
		y = 0;
		for (int i = 0; i < 4; i++) {
			while (true) {
				int nx = x + dx[direct2[i]];
				int ny = y + dy[direct2[i]];
				if (nx <= air || nx >= R || ny < 0 || ny >= C)
					break;
				if (nx == air + 1 && ny == 0) {
					move[x][y] = 0;
					break;
				}
				move[x][y] = move[nx][ny];
				x = nx;
				y = ny;
			}
		}
	}

	private static int calculateResult(int R, int C, int[][] arr) {
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					result += arr[i][j];
				}
			}
		}
		return result;
	}
}