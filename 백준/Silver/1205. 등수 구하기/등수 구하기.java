
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 현재 랭킹 리스트에 있는 점수 개수
        int newScore = Integer.parseInt(st.nextToken()); // 태수의 새로운 점수
        int P = Integer.parseInt(st.nextToken()); // 랭킹 리스트의 최대 크기

        if (N == 0) {
            // 랭킹 리스트가 비어있으면 무조건 1등
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 랭킹 리스트가 가득 차있고, 새로운 점수가 마지막 점수보다 작거나 같으면 랭킹에 들어갈 수 없음
        if (N == P && newScore <= scores[N - 1]) {
            System.out.println(-1);
            return;
        }

        // 등수 계산
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (scores[i] > newScore) {
                rank++;
            } else {
                break; // 점수는 내림차순으로 정렬되어 있으므로 break
            }
        }

        System.out.println(rank);
    }
}