import java.util.Scanner;

public class IterativeInorder {
    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node createNode(Scanner sc) {
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node newNode = new Node(data);

        System.out.println("Enter the left of " + data);
        newNode.left = createNode(sc);

        System.out.println("Enter the right of " + data);
        newNode.right = createNode(sc);

        return newNode;
    }

    public static void main(String[] args) {

    }
}
