import java.util.Scanner;
import java.util.Arrays;

public class ����ű�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] scores = new int[N];
		int B = 1;		// ���� ���
		long sum = 0;	// �Ҹ����� ��
		
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
