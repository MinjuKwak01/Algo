import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N;
    static int[] arr;
    static List<Integer>[] lst;
    static List<Integer> section1;
    static List<Integer> section2;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        section1 = new ArrayList<>();
        section2 = new ArrayList<>();

        String[] s = br.readLine().split(" ");
        for(int i=0; i< N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        lst = new List[N+1];
        for(int i=0; i<= N; i++){
            lst[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);
            for(int j=1; j<=num; j++){
                lst[i].add(Integer.parseInt(s[j]) -1);
            }
        }
        //printArr();
        dfs(0);

        if(res == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(res);
        }

    }

    static void dfs(int depth){
        if(depth==N){
            if(section1.isEmpty() || section2.isEmpty()){
                return;
            }
            if(isConnected(section1) && isConnected(section2)){
                int sum1 =0;
                int sum2 =0;
                for(int k=0; k<section1.size(); k++){
                    sum1 += arr[section1.get(k)];
                }
                for(int l = 0; l<section2.size(); l++){
                    sum2 += arr[section2.get(l)];
                }

                res = Math.min(res, Math.abs(sum2-sum1));
            }
            return;
        }

        section1.add(depth);
        dfs(depth+1);
        section1.remove(section1.size()-1);

        section2.add(depth);
        dfs(depth+1);
        section2.remove(section2.size()-1);
    }

    static boolean isConnected(List<Integer> list){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        q.offer(list.get(0));
        visited[list.get(0)] = true;
        int count = 1;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int i : lst[num]){
                if(visited[i] || !list.contains(i)){
                    continue;
                }
                q.offer(i);
                visited[i] = true;
                count++;
            }
        }
        return count == list.size();
    }

}
