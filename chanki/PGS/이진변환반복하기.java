
import java.util.*;

public class 이진변환반복하기 {
	
	/*
	[이진 변환의 횟수 / 제거된 0의 개수]
	*/

	class Solution {
	    public int[] solution(String s) {
	        int[] answer = new int[2];
	        int cnt = 0;
	        int zeroCnt = 0;
	        
	        while (!s.equals("1")) {
	            ++cnt;
	            int prevL = s.length();
	            s = s.replaceAll("0", "");
	            int currL = s.length();
	            zeroCnt += prevL - currL;
	            s = Integer.toString(currL, 2);
	        }
	        
	        answer[0] = cnt;
	        answer[1] = zeroCnt;
	        
	        return answer;
	    }
	}
}
