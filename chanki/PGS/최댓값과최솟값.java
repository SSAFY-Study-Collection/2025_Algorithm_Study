
import java.util.*;

public class 최댓값과최솟값 {

	class Solution {
		public String solution(String s) {
			String answer = "";

			List<Integer> list = new ArrayList<>();
			int idx = 0;
			int flag = 1;

			String[] strings = s.split(" ");

			for (int i = 0; i < strings.length; ++i) {
				toNum(list, strings[i]);
			}

			Collections.sort(list);
			StringBuilder sb = new StringBuilder();
			sb.append(list.get(0)).append(" ").append(list.get(list.size() - 1));
			answer = sb.toString();

			return answer;
		}

		public void toNum(List<Integer> list, String s) {
			int flag = 1;
			if (s.charAt(0) == '-') {
				flag = -1;
				s = s.replace("-", "");
			}
			list.add(Integer.parseInt(s) * flag);
		}
	}
}
