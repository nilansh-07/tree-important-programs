import java.util.Scanner;

public class TreePractice {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static Node createTree(Scanner sc) {
        System.out.print("Enter data:");
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

    private static int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    private static int treeSize(Node root) {
        if (root == null) {
            return 0;
        }

        return (treeSize(root.left) + treeSize(root.right)) + 1;
    }

    private static int maxTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(maxTree(root.left), maxTree(root.right)));
    }

    private static int minTree(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min(minTree(root.left), minTree(root.right)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree(sc);

        System.out.println("Choose the operation to perform:");
        int choice;

        do {
            System.out.println("1.Tree Traversals.");
            System.out.println("2.Tree Height.");
            System.out.println("3.Tree Size.");
            System.out.println("4.Maximum in Tree.");
            System.out.println("5.Minimum in Tree.");
            System.out.println("0.Exit...");

            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exited...");
                    System.exit(0);
                    break;

                case 1:
                    System.out.println("Tree Traversals:");
                    System.out.print("The Pre-order traversal is: ");
                    preOrder(root);
                    System.out.println();
                    System.out.print("The In-order traversal is: ");
                    inOrder(root);
                    System.out.println();
                    System.out.print("The Post-order traversal is: ");
                    postOrder(root);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Tree Height: " + treeHeight(root));
                    break;

                case 3:
                    System.out.println("Tree Size: " + treeSize(root));
                    break;

                case 4:
                    System.out.println("Maximum in Tree: " + maxTree(root));
                    break;

                case 5:
                    System.out.println("Minimum in Tree: " + minTree(root));
                    break;
                default:
                    System.out.println("Invalid choice! Enter between 1 to 5:");
                    break;
            }

        } while (choice != 0);
    }
}