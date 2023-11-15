import java.util.Scanner;

public class 가장긴감소하는부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n + 1];

        // i번째 원소를 포함하는 가장 긴 감소하는 부분 수열의 길이를 저장하는 배열
        int m[] = new int[n + 1];

        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        // 첫 번째 원소 1로 초기화
        m[1] = 1;

        // 가장 긴 감소하는 부분 수열의 길이 계산
        for (int i = 2; i <= n; i++) {
            m[i] = 1;
            for (int j = 0; j < i; j++) {
                // 현재 원소보다 작은 원소를 찾고, 그 원소를 포함한 부분 수열의 길이가 더 길다면 업데이트
                if (arr[i] < arr[j] && m[i] <= m[j]) {
                    m[i] = m[j] + 1;
                }
                // 현재 원소와 같은 원소를 찾으면 부분 수열의 길이 유지
                else if (arr[i] == arr[j]) {
                    m[i] = m[j];
                }
            }
        }

        // 가장 긴 감소하는 부분 수열의 길이 중 최댓값 찾기
        int max = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(m[i], max);

        System.out.println(max);

        sc.close();
    }
}
