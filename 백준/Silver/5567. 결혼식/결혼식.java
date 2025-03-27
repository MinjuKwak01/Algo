import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N, M;
	static int[][] lst;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// --------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		visited = new boolean[N];
		lst = new int[N][N];

		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			lst[a - 1][b - 1] = 1;
			lst[b - 1][a - 1] = 1;
		}

		List<Integer> friends = new ArrayList<>();
		visited[0] = true;
		for (int i = 0; i < lst[0].length; i++) {
			if (lst[0][i] != 0) {
				friends.add(i);
				visited[i] = true;
				cnt++;
			}

		}

		for (int i = 0; i < friends.size(); i++) {
			for (int j = 0; j < N; j++) {
				int num = friends.get(i);
				if (!visited[j] && lst[num][j] == 1) {
					cnt++;
					visited[j] = true;

				}
			}
		}

		System.out.println(cnt);

	}

}
