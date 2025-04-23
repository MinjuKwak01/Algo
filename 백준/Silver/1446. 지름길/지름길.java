import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Main {
	static int N, D;
	static List<Node> lst;
	static int[] dist;

	static class Node {
		int s;
		int e;
		int l;

		public Node(int s, int e, int l) {
			super();
			this.s = s;
			this.e = e;
			this.l = l;
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		D = Integer.parseInt(s[1]);

		dist = new int[D + 1];
		//초기화를 dist[100] = 100, dist[50] = 50 로 설정
		for (int i = 0; i <= D; i++) {
			dist[i] = i;
		}
		
		lst = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int len = Integer.parseInt(s[2]);

			lst.add(new Node(start, end, len));
		}

		dijkstra(0);
		System.out.println(dist[D]);

	}

	static void dijkstra(int start) {

		//역주행할 수 없으므로 시작지점을 기준으로 오름차순 정렬
		PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.s - n2.s);
		q.offer(new Node(start, 0, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int pos = cur.e;

			for (Node node : lst) {
				//지름길의 처음부분이 시작부분보다 더 멀리 있다면 
				if (node.s >= pos) {
					//도착 지점보다 지름길의 끝 지점이 더 길다면 continue
					if (node.e > D)
						continue;
					
					//일반도로로 이동하는 비용
					int normal = node.s - pos;
					//짧은 거리 갱신
					if (dist[node.e] > dist[pos] + node.l + normal) {
						dist[node.e] = dist[pos] + node.l + normal;
						q.offer(new Node(pos, node.e, dist[node.e]));
					}
				}
			}
			
			//목적지 거리 갱신
			dist[D] = Math.min(dist[pos] + (D - pos), dist[D]);
		}
	}
}