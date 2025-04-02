

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int T;
	static int N, M;
	static int[][] arr;
	static int ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			ans = Integer.MIN_VALUE;
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}

			for (int k = 1; k <= N+1; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int val = search(i, j, k);
						int cost = calc(k, val);
						if (cost >= 0) {
							ans = Math.max(ans, val);
						}
					}
				}
			}

			System.out.println("#" + (t + 1) + " " + ans);
		}

	}

	static int search(int x, int y, int k) {
		// x, y는 현재좌표

		int count = 0;
		// 거리가 범위 안인지 체크
		for (int i = -k+1; i < k; i++) {
			for (int j = -k+1; j < k; j++) {
				if (x + i < 0 || y + j < 0 || x + i >= N || y + j >= N)
					continue;
				else {
					if (isInRange(x + i, y + j, x, y, k)) {
						// 집이 있는지 확인
						if (arr[x + i][y + j] == 1) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	static boolean isInRange(int x, int y, int midx, int midy, int k) {
		return Math.abs(x - midx) + Math.abs(y - midy) < k;
	}

	static int calc(int k, int count) {
		return count * M - (k * k + (k - 1) * (k - 1));
	}

}
