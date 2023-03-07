import java.io.*;
import java.util.*;

public class Main_bj_1991_트리순회 {
    static Node root = new Node("A");
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();
            insertNode(root,parent,leftChild,rightChild);
        }

        root.preOrder(root);
        System.out.println();
        root.inOrder(root);
        System.out.println();
        root.postOrder(root);
    }
    static void insertNode(Node root, String parent, String leftChild, String rightChild){
        if(root.name.equals(parent)){
            root.addLeft(new Node(leftChild));
            root.addRight(new Node(rightChild));
        }
        else{
            if(root.left!=null) insertNode(root.left, parent, leftChild, rightChild);
            if(root.right!=null) insertNode(root.right, parent, leftChild, rightChild);
        }
    }
}
class Node {
    String name;
    Node left;
    Node right;

    // 생성 시 매개변수를 받아 초기화하는 방법으로만 선언 가능
    public Node(String name) {
        this.name = name;
        left = null;
        right = null;
    }

    public void addLeft(Node node) {
        if(node.name.equals(".")) node = null;
        left = node;
    }

    public void addRight(Node node) {
        if(node.name.equals(".")) node = null;
        right = node;
    }
    public void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.name);
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.name);
		inOrder(node.right);
	}

	public void postOrder(Node node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.name);
    }
}