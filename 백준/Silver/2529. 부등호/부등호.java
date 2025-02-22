
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int k;
    static String[] signs;
    static boolean[] visited = new boolean[10]; // 0~9까지 숫자 방문체크용
    static List<String> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        signs = new String[k];
        for (int i = 0; i < k; i++) {
            signs[i] = s[i];
        }

        // 부등호의 앞뒤에 들어가는 숫자는 {0,1,2,3,4,5,6,7,8,9}
        for (int i = 0; i <= 9; i++) {
            visited[i] = true;
            dfs(i, 0, i + "");
        }

        System.out.println(numbers.get(numbers.size() - 1));
        System.out.println(numbers.get(0));

    }

    private static void dfs(int number, int numberIndex, String str) {
        //가능한 숫자 다 더하기
        if (numberIndex == k) {
            numbers.add(str);
        } else {
            for (int i = 0; i <= 9; i++) {
                if (!visited[i]) {
                    // i는 현재 자리에서 사용할 숫자를 순차적으로 시도하는 변수
                    // number는 이전 숫자
                    if (signs[numberIndex].equals("<")) {
                        // number :
                        if (number >= i) {
                            continue;
                        }
                    } else {
                        if (number <= i) {
                            continue;
                        }
                    }
                    visited[i] = true;
                    dfs(i, numberIndex + 1, str + i);
                }
            }
        }
        visited[number] = false;
    }
}
