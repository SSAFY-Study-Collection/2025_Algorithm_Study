import java.util.*;
import java.io.*;

class Solution {
        PriorityQueue<String> q = new PriorityQueue<>((o1,o2)->{
         
                return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
    
        });
    
        public String solution(int[] numbers) {
            String answer = "";
            for(int n : numbers){
                q.add(String.valueOf(n));
            }
            if(q.peek().charAt(0)=='0') return "0";
            while(!q.isEmpty()){
                
                answer += q.poll();
            }
            
            return answer;
        }
}