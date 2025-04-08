
import java.util.*;

public class 야근지수 {

	/*
	- 야근 피로도 = 야근 시작 시점에서 남은 일의 작업량을 제곱하여 더한 값
	- 1시간 동안 작업량 1만큼 처리
	- 퇴근시간까지 남은 시간 N, 각 일에 대한 작업량 works
	최소 야근 피로도는?
	-> 가장 많이 남은 야근 시간 1씩 줄이기
	*/

	class Solution {
	    public long solution(int n, int[] works) {
	        long answer = 0;
	        
	        Queue<Integer> pq = new PriorityQueue<>((o1, o2) 
	                                        -> Integer.compare(o2, o1));
	        
	        for (int work : works) {
	            pq.offer(work);
	        }
	        
	        for (int i=0; i<n; ++i) {
	            int curr = pq.poll();
	            if (curr-1 != 0) {
	                pq.offer(curr-1);
	            }
	            if (pq.isEmpty()) {
	                break;
	            }
	        }
	        
	        while (!pq.isEmpty()) {
	            int curr = pq.poll();
	            answer += curr * curr;
	        }
	        
	        return answer;
	    }
	}
}
