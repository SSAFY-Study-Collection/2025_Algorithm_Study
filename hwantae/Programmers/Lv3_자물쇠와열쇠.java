import java.util.*;
import java.io.*;


class Solution {
    static int[][] m_key;
    static int[][] k;
    static int[][] l;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        k = key;
        l = lock;
        m_key = new int[lock.length+2*key.length-2][lock.length+2*key.length-2];
        for(int r=0; r<lock.length+key.length-1;r++){
            for(int c=0;c<lock.length+key.length-1;c++){
                
                for(int rot = 0; rot<4;rot++){
                m_key = new int[lock.length+2*key.length-2][lock.length+2*key.length-2];

                    set(r,c);
                     // for(int i=0; i<m_key.length;i++){
                     //        for(int j=0;j<m_key.length;j++){
                     //            System.out.print(m_key[i][j] + " ");
                     //        }
                     //        System.out.println();
                     //    }
                    answer |= valid();
                    
                    rotate();

                    
                    }
                }     
            }
        
        
        return answer;
    }
    static private boolean valid(){
        int sum = 1;
        for(int i = 0; i< l.length; i++){
            for(int j= 0; j < l.length; j++){
                sum *= (m_key[i+k.length-1][j+k.length-1]+l[i][j]);
            }
        } 
        // System.out.println();
        if(sum==1) return true;
        return false;
    }
    static private void set(int r, int c){
        for(int i = r; i< r+ k.length; i++){
            for(int j= c; j < c+ k.length; j++){
                m_key[i][j] = k[i-r][j-c];
            }
        }
    }
    static private void rotate(){
        int[][] save_key = new int[k.length][k.length];
        for(int i = 0; i < k.length ; i++){
            for(int j=0; j< k.length ; j++){
                save_key[i][j] = k[k.length-j-1][i];
            }
        }
        for(int i = 0; i < k.length ; i++){
            k[i] = save_key[i].clone();
        }
        
    }
}