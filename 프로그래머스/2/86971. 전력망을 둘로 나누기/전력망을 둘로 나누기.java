import java.util.*;
class Solution {

    static ArrayList<Integer>[] lst;
    static int answer = Integer.MAX_VALUE;
    
    public int dfs(int node, boolean[] visited){
        visited[node] = true;
        int cnt = 1;
        for(int i=0; i< lst[node].size(); i++){
            if(visited[lst[node].get(i)])
                continue;
            cnt = cnt + dfs(lst[node].get(i), visited);
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        
        lst = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            lst[i] = new ArrayList<>();
        }
        
        int length = wires.length;
        for(int i=0; i< length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            lst[a].add(b);
            lst[b].add(a);    
        }
        
        for(int i=0; i<length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
            lst[v1].remove(Integer.valueOf(v2));
            lst[v2].remove(Integer.valueOf(v1));
            
            int cnt = dfs(1, visited);
            int diff = Math.abs(cnt - (n-cnt));
            answer = Math.min(answer, diff);
            
            
            lst[v1].add(v2);
            lst[v2].add(v1);
            
        }
        
        return answer;
    }
}
