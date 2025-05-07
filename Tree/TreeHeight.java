
/**
 * The `TreeHeight` class in Java defines a binary tree structure, allows user input to create the
 * tree, calculates the height of the tree, and performs pre-order, in-order, and post-order
 * traversals.
 */
import java.util.Scanner;

public class TreeHeight {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static Node createTree(Scanner sc) {
        System.out.print("Enter data ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        System.out.println("Enter left child for " + data);
        root.left = createTree(sc);
        System.out.println("Enter right child for " + data);
        root.right = createTree(sc);

        return root;
    }

    private static int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree(sc);

        System.out.println("The Height of tree is:" + treeHeight(root));
    }
}
