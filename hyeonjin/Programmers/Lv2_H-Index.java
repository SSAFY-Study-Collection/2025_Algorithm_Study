import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int N = citations.length;
        int max = citations[0];
        for (int i = 1; i < N; i++) {
            if (citations[i] > max) max = citations[i];
        }
        
        int result = 0;
        for(int h=max; h>=0; h--){
            int count1 = 0;
            int count2 = 0;
            for(int i=0; i<N; i++){
                if(citations[i] >= h){
                    count1++;
                }
                if(citations[i] <= h){
                    count2++;
                }
            }
            if(count1 >= h && count2 <= h) result= Math.max(result,h);
        }
        return result;
    }
}