package com.ssafy.prog;

import java.util.*;
import java.io.*;

class 추석트래픽 {
    static class Traffic{
        double start_time;
        double end_time;
        Traffic(double s, double e){
            this.start_time = s;
            this.end_time = e;
        }
    }
    static List<Traffic> traffics = new ArrayList<>();
    public int solution(String[] lines) {
        int answer = 0;
        for(String l : lines){
            String[] resp = l.split(" ");
            String[] time = resp[1].split(":");
            int second = ((Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1])) * 60;
            double end_time = second + Double.parseDouble(time[2]);
            double start_time = Math.round((end_time - Double.parseDouble(resp[2].replace("s", "")) + 0.001)*1000)/1000.0;
            traffics.add(new Traffic(start_time,end_time));
        }

        for(Traffic t1 : traffics){
            double start = t1.end_time;
            double end = Math.round((t1.end_time + 0.999)*1000)/1000.0;
            int cnt = 0;
            for(Traffic t2 : traffics){
                if(t2.start_time<=end&&t2.end_time>=start){
                    cnt++;
                }else if(t2.end_time>end+4){
                    break;
                }
            }
            answer = Math.max(answer,cnt);
        }
        
        
        return answer;
    }
}