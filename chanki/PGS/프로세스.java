import java.util.ArrayDeque;
import java.util.Queue;

public class 프로세스 {

    class Solution {

        class Process {
            int idx;
            int p;

            Process(int idx, int p) {
                this.idx = idx;
                this.p = p;
            }
        }

        public int solution(int[] priorities, int location) {
            int answer = 0;

            Queue<Process> q = new ArrayDeque<>();
            int[] arr = new int[10];
            for (int i=0; i<priorities.length; ++i) {
                q.add(new Process(i, priorities[i]));
                for (int j=1; j<priorities[i]; ++j) {
                    ++arr[j];
                }
            }

            while (!q.isEmpty()) {
                Process curr = q.poll();

                if (arr[curr.p] > 0) {
                    q.add(curr);
                    continue;
                }

                ++answer;
                if (curr.idx == location) {
                    break;
                }

                for (int i=1; i<curr.p; ++i) {
                    --arr[i];
                }
            }

            return answer;
        }
    }
}
