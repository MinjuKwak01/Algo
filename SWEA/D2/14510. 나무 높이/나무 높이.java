import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int T;
    static int N;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());

            trees = new int[N];
            int max = 0;
            String[] s = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                trees[i] = Integer.parseInt(s[i]);
                max = Math.max(max, trees[i]);
            }

            int odd = 0;
            int even = 0;
            for(int i=0; i<N; i++){
                int diff=  Math.abs(max - trees[i]);
                even += diff/2;
                odd += diff%2;
            }

            if(even > odd){
                while(Math.abs(even-odd) >1){
                    even--;
                    odd+=2;
                }
            }
            
            int result = 0;
            if(odd > even){
                result = odd * 2 -1;
            }else if(odd < even){
                result = even *2;
            }else{
                result = odd + even;
            }

            System.out.println("#" + tc + " " + result);
        }

    }
}