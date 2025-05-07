import java.util.Scanner;

public class SumOfTreeNodes {
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
        System.out.print("Enter the data:");
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

    static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = createTree(sc);

        System.out.print("The Sum of all the nodes in the tree is: " + sumOfNodes(root));
    }
}
