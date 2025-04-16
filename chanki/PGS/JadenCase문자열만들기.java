
import java.util.*;

public class JadenCase문자열만들기 {

	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        
	        StringBuilder sb = new StringBuilder();
	        boolean isFirst = true;
	        
	        for (int i=0; i<s.length(); ++i) {
	            char curr = s.charAt(i);
	            if (curr == ' ') {
	                sb.append(String.valueOf(curr));
	                isFirst = true;
	                continue;
	            }
	            
	            if (Character.isDigit(curr)) {
	                sb.append(String.valueOf(curr));
	                isFirst = false;
	                continue;
	            }
	            
	            if (isFirst) {
	                sb.append(String.valueOf(Character.toUpperCase(curr)));
	                isFirst = false;
	                continue;
	            }
	            sb.append(String.valueOf(Character.toLowerCase(curr)));
	            isFirst = false;
	        }
	        
	        // System.out.println(Character.isLowerCase('a'));
	        // System.out.println(Character.isUpperCase('a'));
	        // System.out.println(Character.toLowerCase('A'));
	        // System.out.println(Character.toUpperCase('a'));
	        
	        answer = sb.toString();
	        return answer;
	    }
	}
}
