import java.util.Scanner;

public class K번째수 {
	static int N;
	static int pivot;
	static int index = 0;
	
	public static void quickSort(int[] a,int s, int e, int K) {	//피벗의 위치를 기준으로 왼쪽과 오른쪽에 대해 재귀적으로 quickSort 호출
		if(s < e) { 	//배열의 크기가 1이상인 경우에만 정렬 수행
			int pivot = partition(a,s,e);
			if(pivot == K) return; 	// 피벗이 K이면 리턴
			else if(K <pivot) quickSort(a,s,pivot-1,K);
			else quickSort(a,pivot+1, e, K);
		}
	}
	
	public static int partition(int[] a, int s, int e) {	//피벗을 기준으로 배열을 분할, 피벗의 위치 반환
		if(s+1 == e) {	//효율성을 위해 배열의 크기가 2인 경우를 따로 처리
			if(a[s] > a[e]) {
				swap(a,s,e);
			}
			return e;
		}
		int M = (s+e) /2;	//중앙값 선택
		swap(a,s,M);	// 중앙 값과 첫 번째 원소 교환(최악의 경우 O(n^2)를 피하기 위함)
		int pivot = a[s];	//피벗을 첫 번째 원소로 설정
		int l = s+1, r = e;	//포인터 초기화
		while(l <= r) {	//피벗 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽
			while(pivot < a[r] && r>0) r--;
			while(pivot > a[l] && l<a.length-1) l++;
			if(l <= r) swap(a,l++,r--);
		}
		a[s] = a[r]; 
		a[r] = pivot;
		return r;	//피벗의 최종 위치 반환
		
	}
	
	public static void swap(int[] a, int start, int end) {	//배열의 두 원소 교환
		int temp = a[end];
		a[end] = a[start];
		a[start] = temp;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();		//배열의 크기 받기
		int[] arr = new int[N];	//배열 생성
		int K = scanner.nextInt();	//K 받기

		for(int i=0; i<N; i++) {
			arr[i] = scanner.nextInt();   
		}
		quickSort(arr, 0, N-1, K-1);	//퀵 정렬하기
		System.out.println(arr[K-1]);	//출력
	}
	

}