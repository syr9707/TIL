import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, K;
	static int[][] arr;
	static boolean[][] check;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		check = new boolean[M][N];
		int section = 0;
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < (endY - startY); j++) {
				for(int k = 0; k < (endX - startX); k++) {
					arr[startY + j][startX + k] = 1;
				}
			}
		}
		
		int[] num = new int[100];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 0 && check[i][j] == false) {
					num[section] = dfs(i, j);
					count = 0;
					section++;
				}
			}
		}
		Arrays.sort(num);
		System.out.println(section);
		for(int i = 100 - section; i < 100; i++) {
			System.out.print(num[i] + " ");
		}

	}
	
	public static int dfs(int startY, int startX) {
		count++;
		check[startY][startX] = true;
		
		int[] X = {0, 0, -1, 1};
		int[] Y = {-1, 1, 0, 0};
		
		for(int i = 0; i < 4; i++) {
			int x = startX + X[i];
			int y = startY + Y[i];
			
			if(x < 0 || x >= N || y < 0 || y >= M) {
				continue;
			}
			
			if(arr[y][x] == 0 && check[y][x] == false) {
				dfs(y, x);
			}
		}
		return count;
	}

}