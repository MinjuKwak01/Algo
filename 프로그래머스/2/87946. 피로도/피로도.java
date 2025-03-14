class Solution {
    static int a;
    static boolean[] visited;
    static int cnt;
    static int ans;
    static void dfs(int len, int[][] dungeons, int depth, int tired){
        ans = Math.max(ans, depth);
 
        for(int i=0; i<len; i++){
            if(!visited[i]){
                if(tired < dungeons[i][0])
                    continue;
                visited[i] = true;
                dfs(len, dungeons, depth+1, tired-dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        int length = dungeons.length;
        
        visited = new boolean[length];
        dfs(length,dungeons, 0, k);
        System.out.println(ans);
        return ans;
    }
}