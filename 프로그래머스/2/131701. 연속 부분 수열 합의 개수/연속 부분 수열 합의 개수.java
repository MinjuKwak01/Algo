import java.util.*;

class Solution {
    static Set<Integer> set;

    public int solution(int[] elements) {
        set = new HashSet<Integer>();

        int length = elements.length;
        
        for(int i=1; i<=length; i++){
            for(int j=0; j< length; j++){
                int sum = 0;
                for(int k=j; k < j+i; k++){
                    sum += elements[k % elements.length];
                }
                set.add(sum);
            }
        }
        // System.out.println(set.toString());
        // System.out.println(set.size());
        return set.size();
    }
}