

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++){
            int flag = 0;
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String first = st.nextToken();
            String second = st.nextToken();

            int[] arr1 = new int[26];
            int[] arr2 = new int[26];

            for(int i =0;i<first.length();i++){
                arr1[first.charAt(i)-97]++;
            }
            for(int i =0;i<second.length();i++){
                arr2[second.charAt(i)-97]++;
            }

            for(int i=0;i<26;i++){
                if(arr1[i] != arr2[i]){
                    flag = 1;
                }
            }
            if (flag == 1) {
                System.out.println("Impossible");
            }else{
                System.out.println("Possible");
            }
        }
    }
}
