import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ÿ�ϸ�2xn {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // n�ޱ�
		
		int[] dp = new int[1001];	// 1<=n<=1000
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i -2] % 10007; // �� ������ 10007�� �������� ������ overflow �߻�
		}
		System.out.println(dp[n]);
	}

}
