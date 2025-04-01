package com.ssafy.prog;

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new ArrayDeque<>();
        int sum = 0;
        
        for(int t :  truck_weights){
            while(true){
                if(bridge.size()==bridge_length){
                    sum -= bridge.poll();
                }
            
                if(sum+t<=weight){              
                    bridge.offer(t);
                    sum += t;
                    answer += 1;
                    break;
                }else{
                    bridge.offer(0);
                    answer += 1;
                } 
            }
            
        }
       
        
        return answer + bridge_length;
    }
}
