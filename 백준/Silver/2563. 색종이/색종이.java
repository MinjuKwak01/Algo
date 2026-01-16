

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[101][101];
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            for(int a=x; a <x+10; a++){
                for(int b=y; b<y+10; b++){
                    arr[a][b] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<=100; i++){
            for(int j=0; j<=100; j++){
                if(arr[i][j] == 1){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}