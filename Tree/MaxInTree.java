/**
 * This Java program defines a binary tree structure and finds the maximum value in the tree.
 */
import java.util.Scanner;

public class MaxInTree {
    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static Node createTree(Scanner sc) {
        System.out.println("Enter data");
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

    private static int maxTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(maxTree(root.left), maxTree(root.right)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree(sc);

        System.out.println("The Maximum node in a tree is: " + maxTree(root));

        sc.close();
    }
}
