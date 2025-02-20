import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int n, m;
	static int[] arr;
	static int[] memo;
	static List<Node> nodeList = new ArrayList<>();

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s[] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		memo = new int[n];
		arr = new int[n];

		s = br.readLine().split(" ");
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
			sum += arr[i];
			memo[i] = sum;
		}

		for (int i = 0; i < m; i++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]) - 1;
			int y = Integer.parseInt(s[1]) - 1;
			Node node = new Node(x, y);
			nodeList.add(node);
		}

		for (int n = 0; n < nodeList.size(); n++) {

			int memoSum = 0;
			int left = nodeList.get(n).x;
			int right = nodeList.get(n).y;
			if (left == right) {
				System.out.println(arr[left]);
			} else {
				if (left != 0) {
					memoSum = memo[right] - memo[left - 1];
				} else {
					memoSum = memo[right];
				}
				System.out.println(memoSum);
			}

		}

	}

}
