
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        //회의시작, 종료 시간이 같은 경우도 있을 경우
        // (1,2) (2,3) (3,3) => 3개
        // (1,2) (3,3) (2,3) => 2개
        //종료시간이 빠른 순,  종료시간이 같다면 시작시간이 빠른순
        @Override
        public int compareTo(Meeting o) {
            return this.end != o.end ? this.end - o.end : this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(meetings); // 종료 시간 기준 정렬
        List<Meeting> result = new ArrayList<>();
        result.add(meetings[0]); // 첫 번째 회의 배정

        for (int i = 1; i < N; i++) {
            if (result.get(result.size() - 1).end <= meetings[i].start) {
                // 마지막으로 배정된 회의의 종료 시간 이후 시작하는 회의 추가
                result.add(meetings[i]);
            }
        }

        System.out.println(result.size()); // 배정된 회의 수 출력
    }
}
