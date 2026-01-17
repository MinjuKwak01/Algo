
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int A, B;
    static List<Long> luckyNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);

        // 4와 7로만 이루어진 수를 재귀적으로 생성
        generateLuckyNumbers(0);

        // A 이상 B 이하인 수의 개수 세기
        int cnt = 0;
        for (long num : luckyNumbers) {
            if (num >= A && num <= B) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    // 4와 7로만 이루어진 수를 재귀적으로 생성
    static void generateLuckyNumbers(long current) {
        if (current > B) {
            return;
        }
        
        if (current >= A) {
            luckyNumbers.add(current);
        }

        // 현재 숫자 뒤에 4를 붙인 수
        generateLuckyNumbers(current * 10 + 4);
        // 현재 숫자 뒤에 7을 붙인 수
        generateLuckyNumbers(current * 10 + 7);
    }
}