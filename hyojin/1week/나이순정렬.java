import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class 나이순정렬 {
    public static void main(String[] args){
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    try {
	    int n = Integer.parseInt(bf.readLine()); //정수 입력
	
	    int[] age = new int[n];
	    String[] name = new String[n]; //배열 생성
	
	    for (int i=0; i< n; i++){
	        String[] input = bf.readLine().split(" ");
	        age[i] = Integer.parseInt(input[0]);
	        name[i] = input[1]; //정보 입력
	    }
	    
	    Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i; //정렬
        }
        Arrays.sort(indexes, Comparator.comparingInt(i -> age[i])); //나이 오름차순
	    
	    for (int i : indexes){
	        System.out.println(age[i]+ " "+ name[i]); //결과 출력
	    }
    } catch (IOException e) {
    	e.printStackTrace();
    }
}
}
