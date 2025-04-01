import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length()/2; i++){
            String ans = "";
            String pvt = "";
            int cnt = 0;
            int idx = 0;
            while(true){
            
                if(pvt.equals(s.substring(idx, idx+i))){
                    cnt++;
                }else{
                    if(cnt>1){
                        ans += cnt;
                    }
                    ans += pvt;
                    
                    pvt = s.substring(idx, idx+i);
                    cnt = 1;
                }
                idx += i;
                if(idx+i>s.length()) break;
            }
            if(cnt>1){
                ans += cnt;
            }
            ans += pvt;
            ans += s.substring(idx);
            answer = Math.min(answer, ans.length());
            
        }
        
        
        return answer==Integer.MAX_VALUE?s.length():answer;
    }
}