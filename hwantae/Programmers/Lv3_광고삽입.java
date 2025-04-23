import java.util.*;
import java.io.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int playTime = parseDate(play_time);
        int advTime = parseDate(adv_time);
        long[] times = new long[360001];        
        List<Integer> starts = new ArrayList<>();

        for(String log : logs){
            String[] splits = log.split("-");
            int start = parseDate(splits[0]);
            int end = parseDate(splits[1]);
            starts.add(start);
            times[start] += 1;
            times[end] += -1;
            
        }
        // 누적 시청자 수 계산
        for(int i = 1; i <= 360000; i++) {
            times[i] += times[i - 1];
        }

        // 누적 시청 시간 계산
        for(int i = 1; i <= 360000; i++) {
            times[i] += times[i - 1];
        }

        long maxView = times[advTime - 1];
        int maxStart = 0;

        // 슬라이딩 윈도우 방식으로 최적 광고 시점 찾기
        for(int i = advTime; i < playTime; i++) {
            long viewTime = times[i] - times[i - advTime];
            if(viewTime > maxView) {
                maxView = viewTime;
                maxStart = i - advTime + 1;
            }
        }

        answer += (maxStart/3600<10)?"0"+ maxStart/3600+ ":":maxStart/3600+ ":";
        answer += ((maxStart%3600)/60<10)?"0"+ (maxStart%3600)/60+ ":" : (maxStart%3600)/60+ ":";
        answer += ((maxStart%60)<10)?"0"+(maxStart%60) : (maxStart%60);
        
        return answer;
    }
    
    private static int parseDate(String str){
        String[] splits = str.split(":");
        return Integer.parseInt(splits[0])*3600+Integer.parseInt(splits[1])*60+Integer.parseInt(splits[2]);
    }
    
}
