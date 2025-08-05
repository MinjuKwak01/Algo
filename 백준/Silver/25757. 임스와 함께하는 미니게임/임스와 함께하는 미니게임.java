
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N;
    static String G;
    static int GI;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        G = s[1];

        if(G.equals("Y")){
            GI = 1;
        }else if(G.equals("F")){
            GI = 2;
        }else{
            GI = 3;
        }

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            String string = br.readLine();
            set.add(string);
        }

        int size = set.size();

        int answer = size/GI;
        System.out.println(answer);


    }
}
