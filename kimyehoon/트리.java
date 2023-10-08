import java.util.*;

public class 트리 {

    static int n, delete;
    static int[] parent;
    static int count;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        parent = new int[n];
        int root = 0;
        for(int i = 0; i < n; i++) {
            parent[i] = scan.nextInt();        
            if(parent[i] == -1) root = i; // 부모가 -1인 노드는 트리의 루트 노드입니다.
        }
        delete = scan.nextInt();    // 삭제할 노드의 번호를 입력받습니다.
        
        deleteNode(delete);
            
        count = 0;
        visited = new boolean[n];
        countLeaf(root);
            
        System.out.println(count);
        
        scan.close();
    }
    
    public static void deleteNode(int d) {
        parent[d] = -2; //삭제된 노드 -2로 표시
        for(int i = 0; i < n; i++) {
            if(parent[i] == d) {
                deleteNode(i);  // 삭제된 노드의 자손 노드들도 삭제합니다.
            }
        }
    }
    
    public static void countLeaf(int s) {
        boolean isLeaf = true; // 현재 노드가 리프 노드인지 판단하는 변수입니다.
        visited[s] = true; // 현재 노드를 방문했음을 표시합니다.
        if(parent[s] != -2) {
            for(int i = 0; i < n; i++) {
                if(parent[i] == s && visited[i] == false) {
                    countLeaf(i); // 자식 노드를 기준으로 리프 노드의 개수를 세어봅니다.

                    isLeaf = false; // 자식 노드가 있으므로 현재 노드는 리프 노드가 아닙니다.
                }
            }
            if(isLeaf) count++; // 현재 노드가 리프 노드인 경우 개수를 증가시킵니다.
        }
    }
}
