import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0; //두번째 포인터
        int sum = arr[0];
        int distance = 0;
        int min = 100001;

        for (int i = 0; i < N; i++) {
            while (sum < S && j < N - 1) {
                sum += arr[++j];
            }
            if (sum >= S) {
                distance = j - i + 1;
                if (distance < min)
                    min = distance;
            }
            sum -= arr[i];
        }
        if (min == 100001) {
            System.out.println(0);
            return;
        }

        System.out.println(min);
    }
}
