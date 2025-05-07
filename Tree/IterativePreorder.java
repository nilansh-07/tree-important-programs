import java.util.Scanner;
import java.util.Stack;

public class IterativePreorder {
    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node createTree(Scanner sc) {
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node newNode = new Node(data);

        System.out.println("Enter the left of " + data);
        newNode.left = createTree(sc);

        System.out.println("Enter the right of " + data);
        newNode.right = createTree(sc);

        return newNode;
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.print(currentNode.data + " ");

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree(sc);

        preOrder(root);
    }
}