
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static Node babyPos;
    static int babySize = 2;
    static List<Node> fishList;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0,1, -1};
    static boolean[][] visited;
    static int[][] cntArr;
    static int result;
    static int eatCount = 0;

    static class Node{
        int x;
        int y;
        int dist;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        fishList = new ArrayList<>();
        visited = new boolean[N][N];
        cntArr = new int[N][N];

        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j] == 9){
                    babyPos = new Node(i, j);
                    arr[i][j] = 0;
                }
            }
        }
        //입력
        while(true){
            //1초 마다 반복
            //먹을 수 있는 물고기 개수가 0이라면 끝
            fishList = new ArrayList<>();
            int fishCount = howManyFish();
            if(fishCount == 0){
                break;
            }
            //먹을 수 있는 물고기 개수가 1개라면
            if(fishCount == 1){
                //그 물고기 있는 자리로 이동
                move();
                //이동한 칸수 배열 확인
                Node node = fishList.get(0);
                int dist = cntArr[node.x][node.y];

                //0이라면 이동 못함
                if(dist == 0){
                    break;
                }
                //물고기 위치로 아기상어 이동
                babyPos.setX(node.x);
                babyPos.setY(node.y);
                //먹은 물고기자리 빈칸으로 만들기
                arr[node.x][node.y] = 0;
                //이동한 거리 더하기
                result += dist;
                //총 먹은 횟수 증가
                eatCount ++;
                //총 먹은 횟수가 아기상어 크기랑 같다면
                if(eatCount == babySize){
                    //아기상어 크기 증가 및 총 먹은 횟수 초기화
                    babySize++;
                    eatCount = 0;
                }
            }else{
                //먹을 수 있는 물고기가 2개 이상이라면 물고기까지의 거리 계산
                if(!calcDist()){  // false면 종료
                    break;
                }
            }
        }
        System.out.println(result);
    }

    //한 싸이클이 끝날때마다 실행
    //얼마나 많은 물고기를 먹을 수 있는지
    static int howManyFish(){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                //0은 빈칸으므로 제외
                if(arr[i][j] < babySize && arr[i][j] != 0){
                    //먹을 수 있는 물고기 리스트에 저장
                    fishList.add(new Node(i, j));
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static boolean calcDist(){
        //일단 이동
        move();
        //물고기 자리에 이동할 수 없다면 제거
        fishList.removeIf(fish -> cntArr[fish.x][fish.y] == 0);

        if(fishList.isEmpty()) {
            // 갈 수 있는 물고기가 없음
            return false;
        }
        //먹을 수 있는 물고기 리스트에 거리 정보 저장
        for(Node fish : fishList){
            fish.dist = cntArr[fish.x][fish.y];
        }

        // 우선순위대로 정렬
        Collections.sort(fishList, (o1, o2) -> {
            if(o1.dist != o2.dist) return o1.dist - o2.dist; // 거리 가까운 순
            if(o1.x != o2.x) return o1.x - o2.x; // 위쪽 우선
            return o1.y - o2.y; // 왼쪽 우선
        });

        //우선순위 물고기
        Node target = fishList.get(0);
        babyPos.setX(target.x);
        babyPos.setY(target.y);

        //빈칸으로 만들고 거리 더함
        arr[target.x][target.y] = 0;
        result+=target.dist;

        //아기 상어 크기 증가 가능 여부 확인해서 증가시킬 수 있다면 증가
        eatCount++;
        if(eatCount == babySize){
            babySize++;
            eatCount=0;
        }
        return true;

    }

    static void move(){

        visited = new boolean[N][N];
        cntArr = new int[N][N];

        Queue<Node> q = new LinkedList<>();
        //초기좌표로 아기상어 위치 저장
        q.add(new Node(babyPos.x, babyPos.y));
        visited[babyPos.x][babyPos.y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for(int i=0; i<4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if(visited[nx][ny])
                    continue;
                //이동하려는 칸의 물고기 크기가 아기상어 크기보다 크다면
                if(arr[nx][ny] > babySize)
                    continue;
                //이동
                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
                cntArr[nx][ny] = cntArr[x][y]+1;
            }
        }


    }
}