

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()); //한 줄 입력받기
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        // 배열 정렬
        Arrays.sort(arr);

        int startPoint = 0;
        int endPoint = N - 1;
        int count = 0;
        int temp = 0;

        // start point와 end point가 만날 때까지 반복
        while (startPoint < endPoint) {
            temp = arr[startPoint] + arr[endPoint];
            // start point + end point > x ?
            if (temp > x) {
                // end point 왼쪽으로 한 칸 이동
                endPoint--;
            }
            // start point + end point < x ?
            else if (temp < x) {
                // start point 오른쪽으로 한 칸 이동
                startPoint++;
            }
            // start point + end point == x ?
            else {
                // start point 오른쪽으로, end point 왼쪽으로 한 칸씩 이동
                startPoint++;
                endPoint--;
                count++;
            }
        }
        System.out.println(count);
    }
}
