import java.util.Scanner;

public class PrintLeafNodes {
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
        System.out.print("Enter data:");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node newNode = new Node(data);

        System.out.println("Enter left of " + data);
        newNode.left = createTree(sc);
        System.out.println("Enter right of " + data);
        newNode.right = createTree(sc);

        return newNode;
    }

    static void printLeafNode(Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeafNode(root.left);
        printLeafNode(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = createTree(sc);
        
        System.out.println("The Leaf nodes of tree are:");
        printLeafNode(root);
    }
}
