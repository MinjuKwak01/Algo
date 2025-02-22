import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static List<String> ans = new ArrayList<>();

    static boolean checkPrime(int num) {
        //소수인지 확인
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int depth, StringBuilder s) {
        if (depth == n) {
            ans.add(s.toString());
            return;
        }

        for (int i = 0; i < 10; i++) {
            s.append(i);
            //2 ~ n자리수가 소수인지 판별
            //소수라면 그 다음 자리수도 소수인지 확인
            if (checkPrime(Integer.parseInt(s.toString()))) {
                dfs(depth + 1, s);
            }
            //숫자 하나 빼주기
            s.setLength(s.length() - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i : new int[]{2, 3, 5, 7}) { // 1자리 소수로 시작
            StringBuilder s = new StringBuilder();
            s.append(i);
            dfs(1, s);
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
