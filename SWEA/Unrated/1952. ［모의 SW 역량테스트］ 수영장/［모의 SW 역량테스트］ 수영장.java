
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int t;
	static int ans = Integer.MAX_VALUE;
	static int[] ticketPrice;
	static int[] plan;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for(int T = 0; T < t; T++) {
			ticketPrice = new int[4];
			plan = new int[12];
			ans = Integer.MAX_VALUE;
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				ticketPrice[i] = Integer.parseInt(s[i]);
			}

			s = br.readLine().split(" ");
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(s[i]);
			}

			dfs(0, 0);

			//1년 요금권이 가장 저렴할 수 있기 때문에 한번 더 최솟값 판별
			int oneYear = ticketPrice[3];
			ans = Math.min(ans, oneYear);
			System.out.println("#" + (T+1) + " " + ans);
		}
		
	}

	static void dfs(int depth, int sum) {
		//3달 이용권을 사용했을때 12월을 넘어가게될 수도 있기 때문에 depth == 12일때만 아닌 depth >=12일때
		if (depth >= 12) {
			ans = Math.min(ans, sum);
			return;
		}

		if (plan[depth] == 0) {
			dfs(depth + 1, sum);
		} else {
			//1일 이용권 요금
			dfs(depth + 1, sum + ticketPrice[0] * plan[depth]);
			//1달 이용권 요금
			dfs(depth + 1, sum + ticketPrice[1]);
			//3달 이용권 요금
			dfs(depth + 3, sum + ticketPrice[2]);
		}
	}

}
