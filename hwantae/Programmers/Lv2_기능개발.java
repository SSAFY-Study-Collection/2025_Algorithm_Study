package com.ssafy.prog;

import java.util.*;
import java.io.*;

class Solution {
    static class Progress{
        int t;
        int s;
        
        Progress(int t, int s){
            this.t = t;
            this.s = s;
        }
    }
    static Queue<Progress> q = new ArrayDeque<>();
    public static List<Integer> solution(int[] progresses, int[] speeds) {
	        List<Integer> answer = new ArrayList<>();
	        for(int i=0;i<progresses.length;i++){
	            q.add(new Progress(progresses[i], speeds[i]));
	        }
	        int time = 0;
	        int count = 0;
	        while(!q.isEmpty()){
	            Progress cur = q.poll();
	            cur.t += time * cur.s;
	            if(cur.t<100) {
	            	if(time!=0) {
	            		answer.add(count);
	            		count = 0;
	            	}
	            	int days = (100-cur.t)/cur.s;
                    if((100-cur.t)%cur.s!=0) {
	            		days += 1;
	            	}
	            	time += days;
	            	count++;
	            }else {
	            	count++;
	            }
	        }
	        answer.add(count);
	        // System.out.println(answer);
	        return answer;
	    }
}