package com.ssafy.prog;

import java.util.*;
import java.io.*;

class Solution {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int answer = 0;
        for(Integer s : scoville){
            q.add(s);
        }
        while(true){
            if(q.size()==1){
                if(q.poll()>=K){
                    answer = answer;
                }else{
                   answer = -1; 
                }
                break;
            }
            int cur1 = q.poll();
            if(cur1>=K){
                break;
            }
            int cur2 = q.poll();
            q.add(cur1 + cur2*2);
            answer++;
        }
        return answer;
    }
    
}