package yujin.PGS;

import java.util.ArrayDeque;
import java.util.TreeMap;
import java.util.Queue;

public class Lv2_프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        TreeMap<Integer, Integer> priorities_map = new TreeMap<>((a, b) -> b - a);
        Queue<int[]> processes = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            priorities_map.put(priorities[i], priorities_map.getOrDefault(priorities[i], 0) + 1);
            processes.offer(new int[]{priorities[i], i});
        }

        while (!processes.isEmpty()) {
            int[] curr = processes.poll();
            if (curr[0] == priorities_map.firstKey()) {
                answer++;
                priorities_map.put(curr[0], priorities_map.get(curr[0]) - 1);

                if (priorities_map.get(curr[0]) == 0) {
                    priorities_map.remove(curr[0]);
                }
                if (curr[1] == location) {
                    break;
                }
            } else {
                processes.offer(curr);
            }
        }
        return answer;
    }
}
