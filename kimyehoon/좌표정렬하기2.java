import java.util.Scanner;
import java.util.Arrays;

public class 좌표정렬하기2 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			arr[i][1] = in.nextInt();
			arr[i][0] = in.nextInt();
		}

		// 좌표를 먼저 x 좌표를 기준으로 오름차순으로 정렬하고, 
        // 만약 x 좌표가 같다면 y 좌표를 기준으로 오름차순으로 정렬합니다.
		Arrays.sort(arr, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1]; // x 좌표가 같으면 y 좌표를 기준으로 정렬합니다.
			} else {
				return e1[0] - e2[0]; // x 좌표가 다르면 x 좌표를 기준으로 정렬합니다.
			}
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][1] + " " + arr[i][0]); // y 좌표와 x 좌표를 출력합니다.
		}
    in.close();
	}
}