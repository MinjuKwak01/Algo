import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while(!(input = br.readLine()).equals("end")){
            boolean hasMoeum = false;
            boolean isAcceptable = true;

            int moeumCnt = 0;
            int jaeumCnt = 0;

            char prev = 0;

            for(int i=0 ; i<input.length(); i++){
                char c = input.charAt(i);

                if(isMoeum(c)){
                    hasMoeum = true;
                    moeumCnt ++;
                    jaeumCnt = 0;
                }else{
                    jaeumCnt++;
                    moeumCnt = 0;
                }

                if(moeumCnt == 3 || jaeumCnt == 3){
                    isAcceptable = false;
                    break;
                }

                if (i>0 && c== prev && !(c=='e' || c== 'o')){
                    isAcceptable = false;
                    break;
                }

                prev = c;
            }

            if(!hasMoeum)
                isAcceptable = false;

            if(isAcceptable){
                System.out.println("<" + input + "> is acceptable.");
            }else{
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
    }
    static boolean isMoeum(char c){
        if("aeiou".indexOf(c) != -1){
            return true;
        }
        return false;
    }
}
