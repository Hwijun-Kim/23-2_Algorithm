import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 트리색칠하기 {

	static int n, INF = 987654321;	//정점의 개수와 무한대 값
	static List<Integer>[] list; 	//그래프의 인접 리스트를 저장하는 배열
	static List<Integer>[] tree; 	//트리 구조를 나타내는 인접 리스트를 저장하는 배열
	static int[][] dp;	//DP를 위한 2차원 배열
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	//정점의 개수 입력
		list = new ArrayList[n+1];
		tree = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();	//배열 초기화
		}
		
		StringTokenizer st = null;
		for(int i=0; i<n-1; i++) {	//n-1개의 간선 정보를 입렵
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);		//list에 간선 정보 추가(양방향)
		}
		
		makeTreeData(1,-1);
		
		dp = new int[n+1][18];	//dp배열 초기화(T(N)의 최소 트리 크기가 2^(N-1)이므로
		for(int i=1; i<n+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int res = INF;
		for(int c=1; c<18; c++) {
			res = Math.min(res, painting(1,c));		
		}
		System.out.println(res);
	}
    
	static int painting(int cur, int color) {
		if(dp[cur][color] != -1) return dp[cur][color];	//이미 계산 되었으면 바로 반환
		
		dp[cur][color]=0;
		int cnt =0;
		for(int nxt : tree[cur]) {
			int tmp = INF;
			for(int i=1; i<18; i++) {
				if(color!=i) {
					tmp = Math.min(tmp, painting(nxt,i));	//현재 색으로 칠하는 비용을 저장하고 연결된 정점들에 대해 최소비용을 계산
				}
			}
			dp[cur][color] += tmp; 
		}
		return dp[cur][color] += color;
	}
	
	static void makeTreeData(int idx, int pa) {	//트리의 구조 생성, idx는 현재 pa는 부모의 정점
		for(int nxt : list[idx]) {	
			if(nxt != pa){	//부모 정점이 아닌 경우에만
				tree[idx].add(nxt);
				makeTreeData(nxt ,idx);
			}
		}
	}
}