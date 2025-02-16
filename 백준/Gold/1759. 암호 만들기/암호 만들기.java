
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int l, c;
    static String[] arr;
    static String[] ans;

    static void dfs(int jaum, int moum, int start, int depth) {

        //탈출 조건
        if (depth == l) {
            if (moum >= 1 && jaum >= 2) {
                for (int i = 0; i < l; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
            }
            return;

        }

        for (int i = start; i < c; i++) {
            ans[depth] = arr[i]; // 현재 문자 선택

            if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                dfs(jaum, moum + 1, i + 1, depth + 1);
            } else {
                dfs(jaum + 1, moum, i + 1, depth + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        l = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);

        arr = new String[c];
        ans = new String[l];

        s = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            arr[i] = s[i];
        }

        Arrays.sort(arr);

//        for(int i=0; i<c;i++){
//            System.out.print(arr[i]);
//        }

        ////입력
        //모음 사용 횟수
        dfs(0, 0, 0, 0);

    }
}
