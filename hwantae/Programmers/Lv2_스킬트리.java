import java.util.*;
import java.io.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> s = new ArrayList<>();
        for(int i = 0; i< skill.length();i++){
            s.add(String.valueOf(skill.charAt(i)));
        }
       for(String tree : skill_trees){
            for(int i = 'A'; i <= 'Z'; i++){
                if(s.contains(String.valueOf((char)i))) {
                    continue;
                }
                tree = tree.replace((String.valueOf((char)i)),"");
            }
           boolean check = true;
           for(int j = 0; j < tree.length(); j++){
               if(!s.get(j).equals(String.valueOf(tree.charAt(j)))){
                   check = false;
               }
           }
           if(check) answer++;
           
       }
        
        
        return answer;
    }
}