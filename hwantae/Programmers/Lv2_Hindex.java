import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(citations[i] <= citations.length-i){
                answer = Math.max(citations[i],answer);
            }
            if(citations[i] >= citations.length-i){
                answer = Math.max(citations.length-i,answer);
            }
        }
        
        
        return answer;
    }
}
