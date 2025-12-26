

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        //i번 누르면 i-1, i, i+1 전구가 바뀜
        //원하는 상태를 만들기 위해 스위치를 최소 몇번 누르면 되는지 알아내는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[] bulbs = br.readLine().toCharArray();
        char[] pressFirstBulbs = Arrays.copyOf(bulbs, bulbs.length);

        // 첫번째 스위치를 누른경우
        pressFirstBulbs[0] = bulbs[0] == '1' ? '0' : '1';
        pressFirstBulbs[1] = bulbs[1] == '1' ? '0' : '1';

        char[] target = br.readLine().toCharArray();

        int count = 0;
        int pressFirstCount = 1;

        for (int i = 1; i < bulbs.length; i++) {
            //0번째 안누른 경우에 i-1번째 전구가 목표랑 다르면
            if (bulbs[i - 1] != target[i - 1]) {
                //i번째 스위치를 눌러서 i-1, i, i+1 전구를 반전
                bulbs[i - 1] = bulbs[i - 1] == '1' ? '0' : '1';
                bulbs[i] = bulbs[i] == '1' ? '0' : '1';
                if (i + 1 < bulbs.length) {
                    bulbs[i + 1] = bulbs[i + 1] == '1' ? '0' : '1';
                }
                count++;
            }

            //0번째 누른경우에 i-1번째 전구가 목표랑 다르면
            if (pressFirstBulbs[i - 1] != target[i - 1]) {
                pressFirstBulbs[i - 1] = pressFirstBulbs[i - 1] == '1' ? '0' : '1';
                pressFirstBulbs[i] = pressFirstBulbs[i] == '1' ? '0' : '1';

                if (i + 1 < pressFirstBulbs.length) {
                    pressFirstBulbs[i + 1] = pressFirstBulbs[i + 1] == '1' ? '0' : '1';
                }
                pressFirstCount++;
            }

        }

        if (isSame(bulbs, target)) {
            System.out.println(count);
        } else if (isSame(pressFirstBulbs, target)) {
            System.out.println(pressFirstCount);
        } else {
            System.out.print(-1);
        }

    }
    //누르는 경우와 안누르는 경우 두 가지를 모두 시도

    public static boolean isSame(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (b[i] != a[i]) {
                return false;
            }
        }

        return true;
    }
}
