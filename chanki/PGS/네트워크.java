import java.util.*;

public class 네트워크 {
	class Solution {

		int[] parent;

		public int solution(int n, int[][] computers) {
			int answer = 0;

			parent = new int[computers.length];
			init();

			for (int i = 0; i < computers.length; ++i) {
				for (int j = 0; j < computers[i].length; ++j) {
					if (computers[i][j] == 1) {
						union(i, j);
					}
				}
			}

			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < parent.length; ++i) {
				set.add(find(i));
			}

			answer = set.size();

			return answer;
		}

		public void init() {
			for (int i = 0; i < parent.length; ++i) {
				parent[i] = i;
			}
		}

		public boolean union(int a, int b) {
			int pa = find(a);
			int pb = find(b);

			if (pa == pb) {
				return false;
			}

			if (pa > pb) {
				parent[pb] = pa;
			} else {
				parent[pa] = pb;
			}

			return true;
		}

		public int find(int x) {
			if (parent[x] == x) {
				return x;
			}

			return parent[x] = find(parent[x]);
		}
	}
}
