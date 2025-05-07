import java.util.ArrayList;
import java.util.Scanner;

public class ATreePractice {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static Node createTree(Scanner sc) {
        System.out.println("Enter data (or -1 to exit): ");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        Node newNode = new Node(data);

        System.out.println("Enter the left child of " + data + " : ");
        newNode.left = createTree(sc);

        System.out.println("Enter the right child of " + data + " : ");
        newNode.right = createTree(sc);

        return newNode;
    }

    private static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static int nodesNo(Node root) {
        if (root == null)
            return 0;

        return nodesNo(root.left) + nodesNo(root.right) + 1;
    }

    private static int maxTree(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;

        return Math.max(root.data, Math.max(maxTree(root.left), maxTree(root.right)));
    }

    private static int minTree(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;

        return Math.min(root.data, Math.min(minTree(root.left), minTree(root.right)));
    }

    private static int treeHeight(Node root) {
        if (root == null)
            return 0;

        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    private static void leftView(Node root, ArrayList<Node> list, int level) {

        if (root == null)
            return;

        if (list.size() == level) {
            list.add(root);
        }

        leftView(root.left, list, level + 1);
        leftView(root.right, list, level + 1);
    }

    private static void rightView(Node root, ArrayList<Node> list, int level) {
        if (root == null)
            return;

        if (list.size() == level) {
            list.add(root);
        }

        rightView(root.right, list, level + 1);
        rightView(root.left, list, level + 1);
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree(sc);

        // System.out.println(nodesNo(root));
        // System.out.println(maxTree(root));
        // System.out.println(minTree(root));
        // System.out.println(treeHeight(root));
        // ArrayList<Node> list = new ArrayList<>();
        // leftView(root, list, 0);

        // System.out.println("Left View of the Tree: ");
        // for (Node node : list) {
        // System.out.print(node.data + " ");
        // }

        // ArrayList<Node> list = new ArrayList<>();
        // rightView(root, list, 0);

        // for (Node node : list) {
        //     System.out.print(node.data + " ");
        // }


    }
}