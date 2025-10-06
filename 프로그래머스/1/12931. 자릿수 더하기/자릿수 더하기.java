import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = String.valueOf(n);
        
        for(char s : str.toCharArray()) {
            answer = answer + (s - '0');
        }


        return answer;
    }
}