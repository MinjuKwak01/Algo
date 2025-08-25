

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            N = Integer.parseInt(br.readLine());
            results = new ArrayList<>();

            // 1부터 시작하여 DFS 수행
            dfs(1, "1");

            Collections.sort(results);
            // 결과 출력 (사전순으로 정렬됨)
            for (String result : results) {
                System.out.println(result);
            }

            // 테스트 케이스 사이에 빈 줄 출력 (마지막 케이스 제외)
            if (i < testCase - 1) {
                System.out.println();
            }
        }
    }

    static void dfs(int currentNum, String expression) {
        // 기저 조건: 모든 숫자를 사용했을 때
        if (currentNum == N) {
            // 수식을 계산해서 0이 되는지 확인
            if (calculate(expression) == 0) {
                results.add(expression);
            }
            return;
        }

        int nextNum = currentNum + 1;

        // 1. 더하기 연산자 추가
        dfs(nextNum, expression + "+" + nextNum);

        // 2. 빼기 연산자 추가
        dfs(nextNum, expression + "-" + nextNum);

        // 3. 공백 (숫자 연결)
        dfs(nextNum, expression + " " + nextNum);
    }

    // 수식을 계산하는 함수
    static int calculate(String expression) {
        // 공백을 제거하여 실제 계산할 수식 만들기
        String cleanExpression = expression.replace(" ", "");

        int result = 0;
        int currentNumber = 0;
        char operator = '+'; // 첫 번째 숫자는 양수로 시작

        for (int i = 0; i < cleanExpression.length(); i++) {
            char c = cleanExpression.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            // 연산자를 만나거나 마지막 문자일 때 계산 수행
            if (c == '+' || c == '-' || i == cleanExpression.length() - 1) {
                if (operator == '+') {
                    result += currentNumber;
                } else if (operator == '-') {
                    result -= currentNumber;
                }

                // 다음 연산을 위해 초기화
                operator = c;
                currentNumber = 0;
            }
        }

        return result;
    }
}