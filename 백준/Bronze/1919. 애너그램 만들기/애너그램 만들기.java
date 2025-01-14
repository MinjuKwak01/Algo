

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i=0;i<first.length();i++){
            arr1[first.charAt(i) - 97]++;
        }
        for(int i=0;i<second.length();i++){
            arr2[second.charAt(i) - 97]++;
        }
        int sum = 0;
        for(int i=0;i<26;i++){
            sum += Math.abs(arr1[i]-arr2[i]);
        }
        System.out.println(sum);
    }
}
