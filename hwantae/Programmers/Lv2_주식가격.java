import java.util.*;
import java.io.*;

class Solution {
   static class Node{
        int t;
        int p;
        Node(int t, int p){
            this.t =t;
            this.p =p;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Node> q = new ArrayDeque();
        
        for(int i = 0; i < prices.length; i++){
            if(q.isEmpty()){
                q.add(new Node(i,prices[i]));                    
            }else {
                if(q.peekLast().p>prices[i]){
                     while(q.peekLast().p>prices[i]) {
                        Node cur = q.pollLast();
                        answer[cur.t] = i - cur.t; 
                        if(q.isEmpty()) break;
                    }
                }
                q.add(new Node(i,prices[i]));
            }
            
        }
        while(!q.isEmpty()){
            Node cur = q.pollLast();
            answer[cur.t] = prices.length - 1 - cur.t; 
        }
        return answer;
    }
}