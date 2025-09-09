
import java.util.Arrays;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        StringBuilder sb = new StringBuilder();
        parent = new int[1000001];
        Arrays.fill(parent, -1);

        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int flag = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);

            if(flag == 0){
                union(a, b);
            }else if(flag == 1){
                if(find(a) == find(b)){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }

    static int find(int num){
        if (parent[num] < 0){
            return num;
        }
        return parent[num] = find(parent[num]);
    }

    static boolean union(int u, int v){
        u = find(u);
        v = find(v);

        if(u == v){
            //이미 같은 집합에 속해있음
            return false;
        }
        if(parent[v] < parent[u]){
            int temp = u;
            u = v;
            v = temp;
        }
        if(parent[u] == parent[v]){
            parent[u] --;
        }
        //랭크 증가
        parent[v] = u;
        return true;
    }
}