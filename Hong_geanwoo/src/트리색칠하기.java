import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ʈ����ĥ�ϱ� {

	static int n, INF = 987654321;	//������ ������ ���Ѵ� ��
	static List<Integer>[] list; 	//�׷����� ���� ����Ʈ�� �����ϴ� �迭
	static List<Integer>[] tree; 	//Ʈ�� ������ ��Ÿ���� ���� ����Ʈ�� �����ϴ� �迭
	static int[][] dp;	//DP�� ���� 2���� �迭
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	//������ ���� �Է�
		list = new ArrayList[n+1];
		tree = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();	//�迭 �ʱ�ȭ
		}
		
		StringTokenizer st = null;
		for(int i=0; i<n-1; i++) {	//n-1���� ���� ������ �Է�
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);		//list�� ���� ���� �߰�(�����)
		}
		
		makeTreeData(1,-1);
		
		dp = new int[n+1][18];	//dp�迭 �ʱ�ȭ(T(N)�� �ּ� Ʈ�� ũ�Ⱑ 2^(N-1)�̹Ƿ�
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
		if(dp[cur][color] != -1) return dp[cur][color];	//�̹� ��� �Ǿ����� �ٷ� ��ȯ
		
		dp[cur][color]=0;
		int cnt =0;
		for(int nxt : tree[cur]) {
			int tmp = INF;
			for(int i=1; i<18; i++) {
				if(color!=i) {
					tmp = Math.min(tmp, painting(nxt,i));	//���� ������ ĥ�ϴ� ����� �����ϰ� ����� �����鿡 ���� �ּҺ���� ���
				}
			}
			dp[cur][color] += tmp; 
		}
		return dp[cur][color] += color;
	}
	
	static void makeTreeData(int idx, int pa) {	//Ʈ���� ���� ����, idx�� ���� pa�� �θ��� ����
		for(int nxt : list[idx]) {	
			if(nxt != pa){	//�θ� ������ �ƴ� ��쿡��
				tree[idx].add(nxt);
				makeTreeData(nxt ,idx);
			}
		}
	}
}