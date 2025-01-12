
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            arr[num]++;
        }

        int sum = arr[6] + arr[9];
        if ((sum % 2) == 0) {
            sum = sum / 2;
        } else {
            sum = sum / 2 + 1;
        }

        int maximum = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9 && maximum < arr[i]) {
                maximum = arr[i];
            } else if (maximum < sum) {
                maximum = sum;
            }
        }

        System.out.println(maximum);

    }
}
