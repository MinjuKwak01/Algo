
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, K;
    static Node[] nodeArr;

    static class Node{
        int gold;
        int silver;
        int dong;

        public Node(int gold, int silver, int dong){
            this.gold = gold;
            this.silver = silver;
            this.dong = dong;
        }

        public int isBetter(int num){
            int score = 1;

            for(int i=1; i<=N; i++){
                Node cur = nodeArr[num];
                Node node = nodeArr[i];
                if(num == i){
                    continue;
                }
                //금 숫자 비교
                if(cur.gold < node.gold){
                    //등수 증가 (밀려남)
                    score++;
                }else if(cur.gold == node.gold){
                    //은 숫자 비교
                    if(cur.silver < node.silver){
                        //등수 증가 (금 동점, 은 숫자 비교) 밀려남
                        score++;
                    }else if(cur.silver == node.silver){
                        //동 숫자 비교
                        if(cur.dong < node.dong){
                            score++;
                        }
                    }
                }
            }
            return score;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        nodeArr = new Node[N+1];
        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);
            int gold = Integer.parseInt(s[1]);
            int silver = Integer.parseInt(s[2]);
            int dong = Integer.parseInt(s[3]);

            nodeArr[num] = new Node(gold, silver, dong);
        }

        System.out.println(nodeArr[K].isBetter(K));

    }
}