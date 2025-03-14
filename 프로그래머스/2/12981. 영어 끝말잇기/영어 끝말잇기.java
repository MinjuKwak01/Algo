 import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] turn = new int[n];
        
        int len = words.length;
        Set<String> set = new HashSet<String>();

        //첫 단어의 마지막 글자
        char ch = words[0].charAt(words[0].length() -1);
        int order = 1;
        set.add(words[0]);
        
        for(int i=1; i<len; i++){

            //이미 말한 단어거나 전 단어의 끝자리로 시작안했을때
            if(set.contains(words[i]) || words[i].charAt(0) != ch){
                int personNum = i % n;
                answer[0] = personNum + 1;
                answer[1] = order;
                break;
            }
            set.add(words[i]);
            if((i + 1) % n == 0)
                order ++;
            
            //끝 문자
            ch = words[i].charAt(words[i].length() -1);
            
        }

        return answer;
    }
}