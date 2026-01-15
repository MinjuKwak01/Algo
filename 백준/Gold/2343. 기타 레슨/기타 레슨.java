
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int mini = Integer.MIN_VALUE;
    static int summation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N];
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
            if(mini < arr[i]){
                mini = arr[i];
            }
            summation += arr[i];
        }

        //mini = 9;
        //summation = 45;

        int res = binarySearch();
        System.out.println(res);
    }

    static boolean canDivide(int[] arr, int M, int size){
        int cnt = 1;
        int cur = 0;

        for(int i=0; i<N; i++){
            if(cur + arr[i] > size){
                cnt++;
                cur = arr[i];
            }else{
                cur += arr[i];
            }
        }
        return cnt<=M;
    }

    static int binarySearch(){
        int answer = summation;

        while(mini <= summation){
            int mid = (mini + summation)/2;
            if(canDivide(arr, M, mid)){
                answer = mid;
                summation = mid-1;
            }else
                mini = mid+1;
        }
        return answer;
    }


}