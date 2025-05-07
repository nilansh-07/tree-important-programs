import java.util.Scanner;
import java.util.Stack;

public class IterativePostorder {

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node createNode(Scanner sc) {
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node newNode = new Node(data);

        System.out.println("Enter the left of " + data);
        newNode.left = createNode(sc);
        System.out.println("Enter the right of " + data);
        newNode.right = createNode(sc);

        return newNode;
    }

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        stack1.push(root);

        Stack<Node> stack2 = new Stack<>();

        while (!stack1.isEmpty()) {
            Node currentNode = stack1.pop();

            stack2.push(currentNode);

            if (currentNode.left != null) {
                stack1.push(currentNode.left);
            }

            if (currentNode.right != null) {
                stack1.push(currentNode.right);
            }
        }
        
        while (!stack2.isEmpty()) {
            Node temp = stack2.pop();
            System.out.print(temp.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = createNode(sc);

        postOrder(root);
    }
}
