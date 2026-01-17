

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    static String[] strArr;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        visited = new boolean[26];
        strArr = new String[N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            String mid = str.substring(4, str.length() - 4);
            strArr[i] = mid;
        }
        visited['c'-'a']=true;
        visited['a'-'a']=true;
        visited['n'-'a']=true;
        visited['i'-'a']=true;
        visited['t'-'a']=true;
        if(K <5){
            System.out.println(0);
            return;
        }else{
            dfs(0, 5);
        }
        System.out.println(result);
    }

    static void dfs(int depth, int cnt){
        if(cnt == K){
            int readableWord = 0;
            for(String word : strArr){
                boolean canRead = true;
                for(char c : word.toCharArray()){
                    if(!visited[c-'a']){
                        canRead = false;
                        break;
                    }
                }
                if(canRead)
                    readableWord++;
            }
            result = Math.max(result, readableWord);
            return;
        }

        if(depth == 26){
            return;
        }

        if(visited[depth]){
            dfs(depth+1, cnt);
            return;
        }

        visited[depth] = true;
        dfs(depth+1, cnt+1);

        visited[depth] = false;
        dfs(depth+1, cnt);

    }
}