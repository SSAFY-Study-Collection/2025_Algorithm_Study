
import java.util.*;
import java.io.*;

class Solution {

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        Deque<String> q = new ArrayDeque<>();
        
        while(n>3){
            if(n%3==0){
                q.add("4");
                n = n/3 - 1;
            }else{
                q.add(String.valueOf(n%3));
                n = n/3;
            }
            
        }
        if(n==3){
            q.add("4");
        }else{
           q.add(String.valueOf(n%3));
        }
        while(!q.isEmpty()){
            answer.append(q.pollLast());
        }
        
        return answer.toString();
    }
}
