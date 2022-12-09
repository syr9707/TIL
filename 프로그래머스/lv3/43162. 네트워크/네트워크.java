import java.util.*;

class Solution {
    
    static boolean[] check;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        check = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!check[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int i, int[][] computers) {
        check[i] = true;
        
        for(int j = 0; j < computers.length; j++) {
            //if(j == i) continue;
            
            if(!check[j] && computers[i][j] == 1) dfs(j, computers);
        }
    }
}