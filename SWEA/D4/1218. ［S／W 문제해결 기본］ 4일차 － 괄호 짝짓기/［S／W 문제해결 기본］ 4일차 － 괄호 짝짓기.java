
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    static int n;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            n = Integer.parseInt(br.readLine());

            arr = new char[n][2];
            Stack<char[]> stk = new Stack<>();
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                arr[i][0] = s.charAt(i);
                if (arr[i][0] == '(' || arr[i][0] == ')') {
                    arr[i][1] = '3';
                } else if (arr[i][0] == '{' || arr[i][0] == '}') {
                    arr[i][1] = '2';
                } else if (arr[i][0] == '[' || arr[i][0] == ']') {
                    arr[i][1] = '1';
                } else if (arr[i][0] == '<' || arr[i][0] == '>') {
                    arr[i][1] = '0';
                }
            }
            //  System.out.println(arr.length);
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                //여는 괄호일 경우 stack에 add
                if (arr[i][0] == '(' || arr[i][0] == '{' || arr[i][0] == '[' || arr[i][0] == '<') {
                    stk.add(arr[i]);
                } else {
                    char[] popped = stk.pop();
                    if (popped[1] != arr[i][1]) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println("#" + t + " " + "0");
            }else{
                System.out.println("#" + t + " " + "1");
            }
        }

    }
}
