import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class VerticalWidth {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static Node createTree(Scanner sc) {
        
        System.out.println("Enter data: ");
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

    static int findVerticalWidth(Node root) {
        if (root == null) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            Node currentNode = currentPair.node;
            int newHd = currentPair.hd;

            set.add(newHd);

            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, newHd - 1));
            }

            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, newHd + 1));
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = createTree(sc);

        System.out.print("The Vertical Width of the tree is: " + findVerticalWidth(root));
    }
}
