import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 이진검색트리 {
	static class Node {
		int num;
		Node left, right;
		
		Node(int num){
			this.num = num;
		}
		void insert(int n) { //새로운 정수값 노드에 삽입
            if (n < this.num) {
            	//값이 현재 노드 값보다 작으면 왼쪽 서브트리에 삽입
                if (this.left == null)
                    this.left = new Node(n);
                else
                    this.left.insert(n);
            } else {
            	//값이 현재 노드 값보다 크면 오른쪽
                if (this.right == null)
                    this.right = new Node(n);
                else
                    this.right.insert(n);
            }
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<Integer> preorder = new ArrayList<>();

        while ((input = br.readLine()) != null && !input.equals("")) {
            preorder.add(Integer.parseInt(input)); //전위 순회 결과 입력받아 리스트에 저장
        }

        Node root = buildTree(preorder, 0, preorder.size() - 1); //이진 검색 트리 생성
        postOrder(root); //후위 순회 결과
    }
	static Node buildTree(List<Integer> preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        Node root = new Node(preorder.get(start));
        int i;
        for (i = start; i <= end; i++) {
            if (preorder.get(i) > root.num) {
                break;
            }
        }
        
        //왼쪽, 오른쪽 서브트리 생성
        root.left = buildTree(preorder, start + 1, i - 1);
        root.right = buildTree(preorder, i, end);

        return root;
    }

    static void postOrder(Node node) { //후위 순회 결과 출력 함수
        if (node == null)
            return;
        postOrder(node.left); // 왼쪽 순회
        postOrder(node.right); // 오른쪽 순회
        System.out.println(node.num); //현재 노드 값 출력
    }
}

