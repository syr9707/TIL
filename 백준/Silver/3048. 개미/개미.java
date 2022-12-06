import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String t1 = br.readLine();
		char[] tmp1 = new char[N];
		for(int i = 0; i < N; i++) {  
			tmp1[i] = t1.charAt(N - i - 1);
		}
		
		char[] tmp2 = br.readLine().toCharArray(); 
		
		char ants[] = new char[N + M]; 
		int dir[] = new int[N + M]; 
		for(int i = 0; i < N; i++) {
			ants[i] = tmp1[i];
			dir[i] = 1;
		}
		for(int i = N; i < N + M; i++) {
			ants[i] = tmp2[i - N];
			dir[i] = 2;
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while(T > 0) {
			T--;
			for(int i = 0; i < N + M - 1; i++) {
				if(dir[i] == 1 && dir[i+ 1] == 2) {
					char t = ants[i];
					ants[i] = ants[i + 1];
					ants[i + 1] = t;
					int td = dir[i];
					dir[i] = dir[i + 1];
					dir[i + 1] = td;
					i++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N + M; i++) {
			sb.append(ants[i]);
		}
		System.out.println(sb);

	}

}