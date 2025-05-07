
/**
 * This Java class implements a binary tree data structure with methods for creating the tree, and
 * performing pre-order, in-order, and post-order traversals.
 */
import java.util.Scanner;

public class TreeImplementation {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
            // this.right = null;
        }
    }

    private static Node createTree(Scanner sc) {
        System.out.println("Enter data (or -1 to exit):");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        // This is the else part although I haven't mentioned here but it runs when the
        // if condition doesn't execute
        Node newNode = new Node(data);

        System.out.println("Enter left child for " + data + ":");
        newNode.left = createTree(sc);

        System.out.println("Enter right child for " + data + ":");
        newNode.right = createTree(sc);

        return newNode;
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree(sc);

        System.out.println("Pre-order traversal:");
        preOrder(root);

        System.out.println("\nIn-order traversal:");
        inOrder(root);

        System.out.println("\nPost-order traversal:");
        postOrder(root);

        sc.close();
    }
}
