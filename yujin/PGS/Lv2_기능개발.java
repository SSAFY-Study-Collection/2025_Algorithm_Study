package yujin.PGS;

import java.util.*;

class Lv2_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> works = new ArrayDeque<>();
        Queue<Integer> speed = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            works.add(progresses[i]);
            speed.add(speeds[i]);
        }

        while(!works.isEmpty()) {
            boolean canRelease = true;
            int finish = 0;
            int work_cnt = works.size();
            for(int i = 0; i < work_cnt; i++) {
                if(works.peek() + speed.peek() < 100) {
                    works.add(works.poll()+speed.peek());
                    speed.add(speed.poll());
                    canRelease = false;
                } else{
                    if(canRelease) {
                        works.poll();
                        speed.poll();
                        finish++;
                    } else{
                        works.add(works.poll()+speed.peek());
                        speed.add(speed.poll());
                    }
                }
            }
            if(finish > 0) {
                ans.add(finish);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}