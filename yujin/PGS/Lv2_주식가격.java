package yujin.PGS;

import java.util.*;

class Lv2_주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Integer> stack = new ArrayDeque<>();

        // 스택 안의 가격은 항상 같거나 오르는 상태를 유지
        // 현재 가격을 스택에 넣으려면, 스택에 현재 가격보다 작은 게 있으면 안됨!

        for(int i = 0; i< prices.length-1; i++){
            // 현재 가격이 더 낮으면, 그 이전에 가격이 높은 인덱스들을 pop하고 기간을 계산
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        // 한번도 가격이 떨어지지 않은 시점들 처리
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length -1 - idx;
        }
        return answer;
    }
}

/*
stack을 사용하면 O(n)으로 가능
가격이 떨어지기 직전까지의 기간을 계산 -> 스택에 '인덱스' 넣기
현재 인덱스와 pop() 인덱스의 차이로 기간 계산
 */