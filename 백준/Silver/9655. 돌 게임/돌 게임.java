
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //1개 또는 3개
        if(N%2==0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }

    }
}
