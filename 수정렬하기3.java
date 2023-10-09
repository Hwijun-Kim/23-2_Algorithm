import java.util.*;
import java.io.*;

public class 수정렬하기3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];
		for (int i=0; i<n; i++)  // n개의 값을 data 배열에 저장
			data[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(data);  // 오름차순으로 정렬
		
		for (int i=0; i<n; i++)  // 정렬된 data 배열의 값을 하나씩 bw에 추가
			bw.write(data[i] + "\n");
		
		bw.flush();  // 출력
		bw.close();
		br.close();
	}
}