
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, M;
	static int[][] arr;
	static List<Node> chickenList;
	static List<Node> houseList;
	static Node[] jiphap;
	//static int sum;
	static int ans = Integer.MAX_VALUE;

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void dfs(int depth, int start) {
		int sum = 0;
		if (depth == M) {
			for (int i = 0; i < houseList.size(); i++) {
				int eachDist = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					Node house = houseList.get(i);
					Node chicken = jiphap[j];

					int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
					eachDist = Math.min(eachDist, dist);
				}

				sum += eachDist;
			}
			ans = Math.min(sum, ans);
			return;
		}

		for (int i = start; i < chickenList.size(); i++) {
			Node node = chickenList.get(i);
			jiphap[depth] = node;
			dfs(depth + 1, i + 1);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new int[N][N];
		jiphap = new Node[M];
		chickenList = new ArrayList<>();
		houseList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
				if (Integer.parseInt(s[j]) == 2) {
					chickenList.add(new Node(i, j));
				} else if (Integer.parseInt(s[j]) == 1) {
					houseList.add(new Node(i, j));
				}
			}
		}

		dfs(0, 0);
		System.out.println(ans);

	}
}
