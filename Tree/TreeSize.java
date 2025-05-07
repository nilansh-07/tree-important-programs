
/**
 * The `TreeSize` class in Java defines a binary tree structure with methods to create a tree from user
 * input and calculate the size of the tree.
 */
import java.util.Scanner;

public class TreeSize {
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

    private static int treeSize(Node root) {
        if (root == null) {
            return 0;
        }

        return treeSize(root.left) + treeSize(root.right) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree(sc);

        System.out.println("The size of the tree is: " + treeSize(root));
    }
}
