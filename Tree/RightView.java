/**
 * This Java program creates a binary tree and prints the right view of the tree by traversing the tree
 * in a specific order.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class RightView {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node createTree(Scanner sc) {
        System.out.println("Enter data ");
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

    static void rightView(Node root, ArrayList<Node> list, int level) {
        if (root == null) {
            return;
        }

        // Ensure list has an entry for the current level
        if (level == list.size()) {
            list.add(root); // Add the first node encountered at this level
        }

        // Traverse right subtree before left subtree
        rightView(root.right, list, level + 1);
        rightView(root.left, list, level + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = createTree(sc);
        ArrayList<Node> list = new ArrayList<>();
        rightView(root, list, 0);

        System.out.println("The right View of the Tree is: ");
        for (Node node : list) {
            System.out.print(node.data + " ");
        }

        sc.close();
    }
}
