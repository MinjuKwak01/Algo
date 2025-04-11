

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

//STL 사용
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder answer = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(n -->0){
            int x = sc.nextInt();
            if(x == 0){ //가장 작은 값을 출력하고 그 값을 배열에서 제거
                if(pq.isEmpty())
                    answer.append(0).append('\n');
                else{ //가장 작은 값이 첫번째 값
                    answer.append(pq.poll()).append('\n');
                }
            }else{ //0이 아니라면 우선순위 큐에 추가
                pq.offer(x);
            }
        }
        System.out.println(answer);
    }
}
