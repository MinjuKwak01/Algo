
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    static int N, L;
    static class Light {
        int pos;
        int red;
        int green;

        Light(int pos, int red, int green) {
            this.pos = pos;
            this.red = red;
            this.green = green;
        }
    }

    static int calculateWaitTime(Light light, int arriveTime) {
        // 신호등 한 주기 = 빨강 + 초록
        int cycle = light.red + light.green;

        // 도착 시간이 한 주기에서 어디쯤인지 계산
        int timeInCycle = arriveTime % cycle;

        // 빨간불 구간이면 대기 (0 ~ red)
        if (timeInCycle < light.red) {
            return light.red - timeInCycle;
        }

        // 초록불 구간이면 바로 통과
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);

        Light[] lights = new Light[N];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int pos = Integer.parseInt(s[0]);
            int red = Integer.parseInt(s[1]);
            int green = Integer.parseInt(s[2]);
            lights[i] = new Light(pos, red, green);
        }

        int currentPos = 0;
        int time = 0;

        // 각 신호등까지 이동하고 대기 시간 계산
        for (int i = 0; i < N; i++) {
            Light light = lights[i];

            // 1. 현재 위치에서 신호등까지 이동
            int distance = light.pos - currentPos;
            time += distance;
            currentPos = light.pos;

            // 2. 신호등에서 대기 시간 계산
            int waitTime = calculateWaitTime(light, time);
            time += waitTime;
        }

        // 3. 마지막 신호등에서 L까지 이동
        time += (L - currentPos);

        System.out.println(time);

    }
}