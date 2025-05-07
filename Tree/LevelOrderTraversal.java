import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node createTree(Scanner sc) {
        System.out.println("Enter data: ");
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

    static ArrayList<Integer> levelOrderTraversal(Node root) {
        // `Queue<Node> queue = new LinkedList<>();` is creating a queue data structure using the
        // `LinkedList` class in Java. Here, we are using the `LinkedList` class to implement the
        // `Queue` interface. This queue will be used to perform level order traversal of a binary tree
        // in the `levelOrderTraversal` method.
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            result.add(currNode.data);

            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree(sc);

        ArrayList<Integer> levelOrder = levelOrderTraversal(root);
        System.out.println("The Level Order traversal is:");
        for (int val : levelOrder) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
