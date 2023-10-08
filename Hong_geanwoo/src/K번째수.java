import java.util.Scanner;

public class K��°�� {
	static int N;
	static int pivot;
	static int index = 0;
	
	public static void quickSort(int[] a,int s, int e, int K) {	//�ǹ��� ��ġ�� �������� ���ʰ� �����ʿ� ���� ��������� quickSort ȣ��
		if(s < e) { 	//�迭�� ũ�Ⱑ 1�̻��� ��쿡�� ���� ����
			int pivot = partition(a,s,e);
			if(pivot == K) return; 	// �ǹ��� K�̸� ����
			else if(K <pivot) quickSort(a,s,pivot-1,K);
			else quickSort(a,pivot+1, e, K);
		}
	}
	
	public static int partition(int[] a, int s, int e) {	//�ǹ��� �������� �迭�� ����, �ǹ��� ��ġ ��ȯ
		if(s+1 == e) {	//ȿ������ ���� �迭�� ũ�Ⱑ 2�� ��츦 ���� ó��
			if(a[s] > a[e]) {
				swap(a,s,e);
			}
			return e;
		}
		int M = (s+e) /2;	//�߾Ӱ� ����
		swap(a,s,M);	// �߾� ���� ù ��° ���� ��ȯ(�־��� ��� O(n^2)�� ���ϱ� ����)
		int pivot = a[s];	//�ǹ��� ù ��° ���ҷ� ����
		int l = s+1, r = e;	//������ �ʱ�ȭ
		while(l <= r) {	//�ǹ� �������� ���� ���� ����, ū ���� ������
			while(pivot < a[r] && r>0) r--;
			while(pivot > a[l] && l<a.length-1) l++;
			if(l <= r) swap(a,l++,r--);
		}
		a[s] = a[r]; 
		a[r] = pivot;
		return r;	//�ǹ��� ���� ��ġ ��ȯ
		
	}
	
	public static void swap(int[] a, int start, int end) {	//�迭�� �� ���� ��ȯ
		int temp = a[end];
		a[end] = a[start];
		a[start] = temp;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();		//�迭�� ũ�� �ޱ�
		int[] arr = new int[N];	//�迭 ����
		int K = scanner.nextInt();	//K �ޱ�

		for(int i=0; i<N; i++) {
			arr[i] = scanner.nextInt();   
		}
		quickSort(arr, 0, N-1, K-1);	//�� �����ϱ�
		System.out.println(arr[K-1]);	//���
	}
	

}