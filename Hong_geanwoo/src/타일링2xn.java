import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링2xn {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // n받기
		
		int[] dp = new int[1001];	// 1<=n<=1000
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i -2] % 10007; // 할 때마다 10007로 나눠주지 않으면 overflow 발생
		}
		System.out.println(dp[n]);
	}

}
