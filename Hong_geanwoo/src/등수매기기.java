import java.util.Scanner;
import java.util.Arrays;

public class 등수매기기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] scores = new int[N];
		int B = 1;		// 실제 등수
		long sum = 0;	// 불만도의 합
		
		for (int i=0; i<N; i++) {
			scores[i] = sc.nextInt();
		}
		
		Arrays.sort(scores);
		
		for (int i=0; i<N; i++) {
			sum += Math.abs(scores[i]-B);
			B++;
		}
		
		System.out.println();
		System.out.println(sum);

	}

}
