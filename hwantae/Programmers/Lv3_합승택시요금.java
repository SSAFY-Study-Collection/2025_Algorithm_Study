class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] graph = new int[n][n];
        
        for(int[] f : fares){
            int from = f[0]-1;
            int to = f[1]-1;
            int weight = f[2];
            
            graph[from][to] = weight;
            graph[to][from] = weight;
        }
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(r==c){
                    graph[r][c] = 0;
                }else{
                    if(graph[r][c]==0){
                        graph[r][c] = Integer.MAX_VALUE;
                    }
                }
                
            }
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(graph[i][k]!=Integer.MAX_VALUE&&graph[k][j]!=Integer.MAX_VALUE){
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                    
                }
            }
        }
         int min = Integer.MAX_VALUE;
         for(int r = 0; r < n; r++){
            int sum = graph[r][s-1] + graph[r][a-1] + graph[r][b-1];
             min = Math.min(min,sum);
         }
        
        
        
        return min;
    }
}